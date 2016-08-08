import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class NFLDrafter extends JFrame {

    DefaultListModel<NFLTeam> teams = new DefaultListModel<>();
    DefaultListModel<NFLPlayer> availablePlayers = new DefaultListModel<>();
    DefaultListModel<NFLPlayer> filteredPlayers = new DefaultListModel<>();
    DefaultListModel<NFLPlayer> draftedPlayers = new DefaultListModel<>();

    private NFLPlayer currentPlayer;
    private NFLPlayer playerToRemove;
    private NFLTeam selectedTeam;
    private JButton draftPlayerButton;
    private JButton removePlayerButton;


    private NFLDrafter(String name) {
        super(name);

        setPreferredSize(new Dimension(1024, 768));


        NFLTeam[] teamValues = NFLTeam.values();
        for (int i = 0; i < teamValues.length; i++) {
            teams.add(i, teamValues[i]);

            for (int j = 0; j < 6; j++) {

                OffensivePlayer newOPlayer = new OffensivePlayer();
                newOPlayer.setTeam(teamValues[i]);
                newOPlayer.setName(teamValues[i] + " Player " + (j + 1));
                availablePlayers.add(i + j, newOPlayer);

                DefensivePlayer newDPlayer = new DefensivePlayer();
                newDPlayer.setTeam(teamValues[i]);
                newDPlayer.setName(teamValues[i] + " Player " + (j + 10));
                availablePlayers.add(i + j, newDPlayer);
            }
        }


    }

    private JScrollPane createAllTeamsComponent() {

        //create list of all players to put in ui

        JList<NFLTeam> allTeamsList = new JList<>(this.teams);
        allTeamsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        allTeamsList.setLayoutOrientation(JList.VERTICAL);
        allTeamsList.setVisibleRowCount(-1);

        // create scrollable panel for our all players
        JScrollPane allTeamsPane = new JScrollPane();
        allTeamsPane.setPreferredSize(new Dimension(150, 600));
        allTeamsPane.setAutoscrolls(true);
        allTeamsPane.setViewportView(allTeamsList);

        allTeamsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                JList lsm = (JList) e.getSource();
                int selectedIndex = lsm.getSelectedIndex();

                this.selectedTeam = NFLTeam.values()[selectedIndex];

                filterPlayers();
            }
            //set details information
        });


        return allTeamsPane;
    }

    private void filterPlayers() {
        this.filteredPlayers.clear();
        int apSize = this.availablePlayers.getSize();
        int fpSize = 0;
        for (int i = 0; i < apSize; i++) {
            NFLPlayer cPlayer = this.availablePlayers.get(i);
            if (cPlayer.getTeam() == this.selectedTeam && !cPlayer.isDrafted) {
                this.filteredPlayers.add(fpSize++, cPlayer);
            }
        }
    }

    private JScrollPane createAvailablePlayersComponent() {
        //create list of all players to put in ui

        JList<NFLPlayer> availablePlayersList = new JList<>(this.filteredPlayers);
        availablePlayersList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        availablePlayersList.setLayoutOrientation(JList.VERTICAL);
        availablePlayersList.setVisibleRowCount(-1);

        // create scrollable panel for our all players
        JScrollPane availablePlayersPane = new JScrollPane();
        availablePlayersPane.setPreferredSize(new Dimension(150, 600));
        availablePlayersPane.setAutoscrolls(true);
        availablePlayersPane.setViewportView(availablePlayersList);

        availablePlayersList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                JList lsm = (JList) e.getSource();
                int selectedIndex = lsm.getSelectedIndex();
                if (selectedIndex > -1){
                    this.currentPlayer = filteredPlayers.get(selectedIndex);
                    //set details information
                    JOptionPane.showMessageDialog(null, this.currentPlayer.getStats());
                    this.draftPlayerButton.setEnabled(true);
                }
            }
        });

        return availablePlayersPane;
    }

    private JScrollPane createDraftedPlayersComponent() {
        // create scrollable panel for drafted players

        JList<NFLPlayer> draftedPlayersList = new JList<>(draftedPlayers);
        draftedPlayersList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        draftedPlayersList.setLayoutOrientation(JList.VERTICAL);
        draftedPlayersList.setVisibleRowCount(-1);


        JScrollPane draftedPlayersPane = new JScrollPane();
        draftedPlayersPane.setPreferredSize(new Dimension(150, 600));
        draftedPlayersPane.setAutoscrolls(true);
        draftedPlayersPane.setViewportView(draftedPlayersList);

        draftedPlayersList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                JList lsm = (JList) e.getSource();
                int selectedIndex = lsm.getSelectedIndex();
                if (selectedIndex > -1){
                    this.playerToRemove = this.draftedPlayers.get(selectedIndex);

                    this.removePlayerButton.setEnabled(true);
                }
            }
        });

        return draftedPlayersPane;
    }

    private Component createControlsComponent() {

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(3, 4));

        this.draftPlayerButton = new JButton("Draft Player");
        this.draftPlayerButton.setEnabled(false);


        this.removePlayerButton = new JButton("Un-draft Player");
        this.removePlayerButton.setEnabled(false);

        this.removePlayerButton.addActionListener(e -> {
            this.draftedPlayers.removeElement(this.playerToRemove);
            this.currentPlayer.isDrafted = false;

            this.filterPlayers();
            this.removePlayerButton.setEnabled(false);
        });

        // set up event handler for draft player button
        // take the selected player and add it to the list.
        this.draftPlayerButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, this.currentPlayer.celebrate());

            this.draftedPlayers.add(draftedPlayers.getSize(), this.currentPlayer);
            this.currentPlayer.isDrafted = true;

            this.filterPlayers();
            this.draftPlayerButton.setEnabled(false);
        });

        controls.add(this.removePlayerButton);
        controls.add(this.draftPlayerButton);

        return controls;
    }

    private void addComponentsToPane(final Container pane) {

        final JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(0, 3));
        mainPanel.setAutoscrolls(true);


        TextField playerName = new TextField();
        playerName.setVisible(true);
        playerName.setEditable(false);
        playerName.setPreferredSize(new Dimension(150, 600));


        //add components to the main panel
        mainPanel.add(createAllTeamsComponent());
        mainPanel.add(createAvailablePlayersComponent());
        mainPanel.add(createDraftedPlayersComponent());

        pane.add(mainPanel, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(createControlsComponent(), BorderLayout.SOUTH);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and name the window
        NFLDrafter drafterWindow = new NFLDrafter("NFL Draft Simulator");
        // make sure we exit cleanly when closed.
        drafterWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        drafterWindow.addComponentsToPane(drafterWindow.getContentPane());
        //Display the window.
        drafterWindow.pack();
        drafterWindow.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(NFLDrafter::createAndShowGUI);
    }

}
