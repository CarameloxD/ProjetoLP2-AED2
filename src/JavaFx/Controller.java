package JavaFx;

import GeoCaching.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import static GeoCaching.Main.*;


public class Controller {
    int p;
    private static final int radius = 15;
    private String basicUsersFXtxt = (".//data//basicUsersFX.txt");
    private String premiumUsersFXtxt = (".//data//premiumUsersFX.txt");
    private String adminUsersFXtxt = (".//data//adminUsersFX.txt");
    private String cachesFXtxt = (".//data//cachesFX.txt");
    private String travelBugsFXtxt = (".//data//travelBugsFX.txt");

    private Geocaching<Node> Geocaching;

    public MenuItem infoTxtMenu;
    public MenuItem infoBinMenu;
    public MenuItem graphTxtMenu;
    public MenuItem graphBinMenu;
    public MenuItem infoSaveTxtMenu;
    public MenuItem infoSaveBinMenu;
    public MenuItem graphTxtSaveMenu;
    public MenuItem graphBinSaveMenu;

    public Pane graphPane;
    public ComboBox<String> regiaoCombo;
    public ComboBox<String> dificuldadeCombo;
    public ComboBox<String> tipoCombo;
    public ComboBox<String> partidaCombo;
    public ComboBox<String> destinoCombo;

    public TextField VTnomeTextField;
    public TextField VTregiaoTextField;
    public TextField VTxTextField;
    public TextField VTyTextField;
    public TextField VTpInteresseTextField;
    public TextField VTdificuldadeTextField;
    public TextField VTtipoTextField;
    public Button VTadd1Button;

    public TextField VTvCache;
    public TextField VTwCache;
    public TextField VTdistanciaAdd;
    public TextField VTtempoAdd;
    public Button VTadd2Button;

    public ListView<Cache> VT1ListViewCache;
    public Button VTremoveButton;

    public ListView<Cache> VT2ListViewCache;
    public Button VTeditButton;

    public TextField VTedit1TF;
    public TextField VTedit2TF;
    public TextField VTedit3TF;
    public TextField VTedit4TF;
    public TextField VTedit5TF;
    public TextField VTedit6TF;
    public TextField VTedit7TF;
    public Button VT1confirmButton;

    public ListView<Object> VTligacaoListView;
    public Button VTligacaoEditButton;

    public TextField VT1edgeEditTF;
    public TextField VT2edgeEditTF;
    public TextField VT3edgeEditTF;
    public TextField VT4edgeEditTF;
    public Button VT2confirmButton;

    public TableColumn<Cache, String> dadosCacheV;
    public TableColumn<Cache, String> dadosCacheW;
    public ComboBox<Cache> vCache;
    public ComboBox<Cache> wCache;
    public Button distanceButton;
    public TextField resultDistance;

    public TableColumn<Utilizador, Integer> idUtilizadores;
    public TableColumn<Utilizador, String> nomeUtilizadores;
    public TableColumn<Utilizador, String> tipoUtilizadores;
    public TableColumn<Utilizador, Integer> nItemsUtilizadores;
    public TableColumn<Utilizador, String> itemsUtilizadores;
    public TextField nomeUtilizadoresTextField;
    public TextField tipoUtilizadoresTextField;
    public TextField itemsUtilizadoresTextField;
    public Button adicionarUtilizadores;
    public Button removerUtilizadores;

    public TableColumn<Cache, String> nomeGeocaches;
    public TableColumn<Cache, String> tipoGeocaches;
    public TableColumn<Cache, String> regiaoGeocaches;
    public TableColumn<Cache, Float> xGeocaches;
    public TableColumn<Cache, Float> yGeocaches;
    public TableColumn<Cache, Integer> nItemsGeocaches;
    public TableColumn<Cache, String> itemsGeocaches;
    public TextField nomeGeocachesTextField;
    public TextField tipoGeocachesTextField;
    public TextField regiaoGeocachesTextField;
    public TextField xGeocachesTextField;
    public TextField yGeocachesTextField;
    public TextField itemsGeocachesTextField;
    public Button adicionarGeocaches;
    public Button removerGeocaches;

    public TableColumn<Log, String> geocacheLog;
    public TableColumn<Log, String> dataLogs;
    public TableColumn<Log, String> infoLogs;
    public TableColumn<Log, String> mensagemLogs;
    public TextField dataLogsTextField;
    public TextField infoLogsTextField;
    public TextField mensagemLogsTextField;
    public TextField cacheLogsTextField;
    public Button addLogs;
    public Button removeLogs;

    public TableColumn<TravelBug, String> nomeTravelBugs;
    public TableColumn<TravelBug, String> userTravelBugs;
    public TableColumn<TravelBug, String> cacheTravelBugs;
    public TableColumn<TravelBug, String> objetivoTravelBugs;
    public TextField nomeTravelBugsTextField;
    public TextField userTravelBugsTextField;
    public TextField cacheTravelBugsTextField;
    public TextField objetivoTravelBugsTextField;
    public Button addTravelBugs;
    public Button removeTravelBugs;

    public TableColumn<Log, String> travelbugHistoricoTB;
    public TableColumn<Log, String> dataHistoricoTB;
    public TableColumn<Log, String> infoHistoricoTB;
    public TableColumn<Log, String> mensagemHistoricoTB;
    public TextField dataHistoricoTBTextField;
    public TextField infoHistoricoTBTextField;
    public TextField mensagemHistoricoTBTextField;
    public TextField travelbugHistoricoTBTextField;

    public Button addHistoricoTB;
    public Button removeHistoricoTB;

    public TableView<TravelBug> travelbugsTable;
    public TableView<Log> historicoTable;
    public TableView<Log> logsTable;
    public TableView<Cache> geocachesTable;
    public TableView<Utilizador> usersTable;

    public Controller(JavaFx.Geocaching<Node> geocaching) {
        Geocaching = geocaching;
    }

    public void initialize() {
        //Tornar as Tables editáveis
        usersTable.setEditable(true);
        geocachesTable.setEditable(true);
        logsTable.setEditable(true);
        travelbugsTable.setEditable(true);
        historicoTable.setEditable(true);

        //Tornar as Colunas não editáveis
        nItemsUtilizadores.setEditable(false);
        nItemsGeocaches.setEditable(false);
        dataLogs.setEditable(false);
        dataHistoricoTB.setEditable(false);

        //Users
        idUtilizadores.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nomeUtilizadores.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tipoUtilizadores.setCellValueFactory(new PropertyValueFactory<>("perm"));
        nItemsUtilizadores.setCellValueFactory(new PropertyValueFactory<>("n_items"));
        itemsUtilizadores.setCellValueFactory(new PropertyValueFactory<>("descricaoItems"));

        //Edit Users
        idUtilizadores.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nomeUtilizadores.setCellFactory(TextFieldTableCell.forTableColumn());
        tipoUtilizadores.setCellFactory(TextFieldTableCell.forTableColumn());
        nItemsUtilizadores.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        itemsUtilizadores.setCellFactory(TextFieldTableCell.forTableColumn());

        //Caches
        nomeGeocaches.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tipoGeocaches.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        regiaoGeocaches.setCellValueFactory(new PropertyValueFactory<>("Regiao"));
        xGeocaches.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        yGeocaches.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        nItemsGeocaches.setCellValueFactory(new PropertyValueFactory<>("n_items"));
        itemsGeocaches.setCellValueFactory(new PropertyValueFactory<>("descricaoItems"));

        //Editar Caches
        nomeGeocaches.setCellFactory(TextFieldTableCell.forTableColumn());
        tipoGeocaches.setCellFactory(TextFieldTableCell.forTableColumn());
        regiaoGeocaches.setCellFactory(TextFieldTableCell.forTableColumn());
        xGeocaches.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        yGeocaches.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        nItemsGeocaches.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        itemsGeocaches.setCellFactory(TextFieldTableCell.forTableColumn());

        //Logs
        geocacheLog.setCellValueFactory(new PropertyValueFactory<>("cacheTravelBug"));
        dataLogs.setCellValueFactory(new PropertyValueFactory<>("Data"));
        infoLogs.setCellValueFactory(new PropertyValueFactory<>("Info"));
        mensagemLogs.setCellValueFactory(new PropertyValueFactory<>("Mensagem"));

        //Editar Logs
        geocacheLog.setCellFactory(TextFieldTableCell.forTableColumn());
        dataLogs.setCellFactory(TextFieldTableCell.forTableColumn());
        infoLogs.setCellFactory(TextFieldTableCell.forTableColumn());
        mensagemLogs.setCellFactory(TextFieldTableCell.forTableColumn());

        //TravelBugs
        nomeTravelBugs.setCellValueFactory(new PropertyValueFactory<>("nome"));
        userTravelBugs.setCellValueFactory(new PropertyValueFactory<>("nomeCriador"));
        cacheTravelBugs.setCellValueFactory(new PropertyValueFactory<>("cacheInicial"));
        objetivoTravelBugs.setCellValueFactory(new PropertyValueFactory<>("objetivo"));

        //Editar TravelBugs
        nomeTravelBugs.setCellFactory(TextFieldTableCell.forTableColumn());
        userTravelBugs.setCellFactory(TextFieldTableCell.forTableColumn());
        cacheTravelBugs.setCellFactory(TextFieldTableCell.forTableColumn());
        objetivoTravelBugs.setCellFactory(TextFieldTableCell.forTableColumn());

        //Historico TB
        travelbugHistoricoTB.setCellValueFactory(new PropertyValueFactory<>("cacheTravelBug"));
        dataHistoricoTB.setCellValueFactory(new PropertyValueFactory<>("Data"));
        infoHistoricoTB.setCellValueFactory(new PropertyValueFactory<>("Info"));
        mensagemHistoricoTB.setCellValueFactory(new PropertyValueFactory<>("Mensagem"));

        //Editar Historico TB
        travelbugHistoricoTB.setCellFactory(TextFieldTableCell.forTableColumn());
        dataHistoricoTB.setCellFactory(TextFieldTableCell.forTableColumn());
        infoHistoricoTB.setCellFactory(TextFieldTableCell.forTableColumn());
        mensagemHistoricoTB.setCellFactory(TextFieldTableCell.forTableColumn());

        //handleGerarGrafoCache();
        handleGerarEvitarGrafoCache("norte", null, null);

        showDestinoComboBox();
        showDificuldadeComboBox();
        showPartidaComboBox();
        showRegiaoComboBox();
        showTipoComboBox();
    }

    /*-----------------------------------------LEITURA TXT P/TABELAS-------------------------------------------------*/

    /**
     * Carrega toda a informação (Utilizadores, Caches, TravelBugs, Logs e histórico
     * dos travelBugs) para as tabelas da interface.
     *
     * @param actionEvent
     * @throws IOException
     */

    public void handleCarregarInfoTXT(ActionEvent actionEvent) throws IOException {
        ArrayList<Basic> basicUsers = readBasicUsersFromFile(basicUsersFXtxt);
        ArrayList<Admin> adminUsers = readAdminUsersFromFile(adminUsersFXtxt);
        ArrayList<Premium> premiumUsers = readPremiumUsersFromFile(premiumUsersFXtxt);
        ArrayList<TravelBug> travelbugsArrayList = readTravelBugsFromFile(travelBugsFXtxt);
        ArrayList<Cache> cachesArrayList = new ArrayList<>();
        ArrayList<Log> LogsTravelBug = new ArrayList<>();
        ArrayList<Log> LogsCache = new ArrayList<>();

        for (String s : caches.keys())
            cachesArrayList.add(caches.get(s));

        for (TravelBug tb : travelbugsArrayList) {
            if (!tb.getHistorico().isEmpty())
                for (int i : tb.getHistorico().keys()) {
                    LogsTravelBug.add(tb.getHistorico().get(i));
                }
        }
        for (Cache c : cachesArrayList) {
            if (!c.getLogs().isEmpty())
                for (int i : c.getLogs().keys())
                    LogsCache.add(c.getLogs().get(i));
        }

        usersTable.getItems().addAll(basicUsers);
        usersTable.getItems().addAll(premiumUsers);
        usersTable.getItems().addAll(adminUsers);
        geocachesTable.getItems().addAll(cachesArrayList);
        travelbugsTable.getItems().addAll(travelbugsArrayList);
        historicoTable.getItems().addAll(LogsTravelBug);
        logsTable.getItems().addAll(LogsCache);
    }

    /**
     * Leitura de dados de um ficheiro de INPUT
     *
     * @param path Caminho para o ficheiro ler
     * @return retorna o arraylist com as utilizadores basics
     */
    private static ArrayList<Basic> readBasicUsersFromFile(String path) {
        ArrayList<Basic> basicUsers = new ArrayList<>();
        In in = new In(path);

        while (!in.isEmpty()) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String line = in.readLine();
                String[] fields = line.split(", ");
                Basic b = new Basic(Integer.parseInt(fields[0]), fields[1], fields[2]);
                for (int k = 0; k < (Integer.parseInt(fields[3])); k++) {
                    Item item = new Item(fields[4 + k]);
                    b.getItems().add(item);
                }
                basicUsers.add(b);
                basics.put(b.getID(), b);
            }
        }
        return basicUsers;
    }

    /**
     * Leitura de dados de um ficheiro de INPUT
     *
     * @param path Caminho para o ficheiro ler
     * @return retorna o arraylist com as utilizadores Admin
     */
    private static ArrayList<Admin> readAdminUsersFromFile(String path) {
        ArrayList<Admin> adminUsers = new ArrayList<>();
        In in = new In(path);

        while (!in.isEmpty()) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String line = in.readLine();
                String[] fields = line.split(", ");
                Admin a = new Admin(Integer.parseInt(fields[0]), fields[1], fields[2]);
                for (int k = 0; k < (Integer.parseInt(fields[3])); k++) {
                    Item item = new Item(fields[4 + k]);
                    a.getItems().add(item);
                }
                adminUsers.add(a);
                admins.put(a.getID(), a);
            }

        }
        return adminUsers;
    }

    /**
     * Leitura de dados de um ficheiro de INPUT
     *
     * @param path Caminho para o ficheiro ler
     * @return retorna o arraylist com as utilizadores premium
     */
    private static ArrayList<Premium> readPremiumUsersFromFile(String path) {
        ArrayList<Premium> premiumUsers = new ArrayList<>();
        In in = new In(path);

        while (!in.isEmpty()) {
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String line = in.readLine();
                String[] fields = line.split(", ");
                Premium p = new Premium(Integer.parseInt(fields[0]), fields[1], fields[2]);
                for (int k = 0; k < (Integer.parseInt(fields[3])); k++) {
                    Item item = new Item(fields[4 + k]);
                    p.getItems().add(item);
                }
                premiumUsers.add(p);
                premiums.put(p.getID(), p);
            }
        }
        return premiumUsers;
    }

    /**
     * Leitura de dados de um ficheiro de INPUT
     *
     * @param path Caminho para o ficheiro ler
     */
    static void readCachesFromFile(String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            int s = Integer.parseInt(in.readLine());
            for (int i = 0; i < s; i++) {
                String line = in.readLine();
                String[] aux = line.split(", ");
                for (int j = 0; j < Integer.parseInt(aux[0]); j++) {
                    String line2 = in.readLine();
                    String[] field = line2.split(", ");
                    Cache c = new Cache(field[0], aux[1], Float.parseFloat(field[2]), Float.parseFloat(field[3]),
                            null, null, field[1]);
                    for (int k = 0; k < Integer.parseInt(field[4]); k++) {
                        Item item = new Item(field[5 + k]);
                        c.getItems().add(item);
                    }
                    //c.setN_items(c.getItems().size());
                    String nlogs = in.readLine();
                    for (int l = 0; l < Integer.parseInt(nlogs); l++) {
                        String[] logs = in.readLine().split(", ");
                        Date date = new Date(Integer.parseInt(logs[0]), Integer.parseInt(logs[1]),
                                Integer.parseInt(logs[2]), Integer.parseInt(logs[3]), Integer.parseInt(logs[4]),
                                Integer.parseInt(logs[5]));
                        Log log = new Log(date, (logs[6] + ", " + logs[7] + ", " + logs[8]), logs[9]);
                        c.addLogs(log);
                    }
                    caches.put(c.getNome(), c);
                }
            }
        }
    }

    /**
     * Leitura de dados de um ficheiro de INPUT
     *
     * @param path Caminho para o ficheiro ler
     * @return retorna o arraylist com os travelbugs
     */
    private static ArrayList<TravelBug> readTravelBugsFromFile(String path) {
        ArrayList<TravelBug> travelBugsArrayList = new ArrayList<>();
        In in = new In(path);

        while (!in.isEmpty()) {
            int j = Integer.parseInt(in.readLine());
            for (int i = 0; i < j; i++) {
                String line = in.readLine();
                String[] fields = line.split(", ");
                TravelBug tb = new TravelBug(fields[0], fields[1], null, 0.0f,
                        0.0f, fields[2], fields[3]);

                int k = Integer.parseInt(in.readLine());
                for (int l = 0; l < k; l++) {
                    String[] lineLog = in.readLine().split(", ");
                    Date date = new Date(Integer.parseInt(lineLog[0]), Integer.parseInt(lineLog[1]),
                            Integer.parseInt(lineLog[2]), Integer.parseInt(lineLog[3]), Integer.parseInt(lineLog[4]),
                            Integer.parseInt(lineLog[5]));
                    String info = lineLog[6] + ", " + lineLog[7] + ", " + lineLog[8];
                    Log log = new Log(date, info, lineLog[9]);
                    tb.getHistorico().put(log.getId(), log);
                }
                travelbugs.put(tb.getNome(), tb);
                travelBugsArrayList.add(tb);
            }
        }
        return travelBugsArrayList;
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------- POPULAR COMBOBOXS -------------------------------------------------*/

    public void showRegiaoComboBox() {
        regiaoCombo.getItems().add("Norte");
        regiaoCombo.getItems().add("Centro");
        regiaoCombo.getItems().add("Sul");
    }

    public void showDificuldadeComboBox() {
        dificuldadeCombo.getItems().add("Facil");
        dificuldadeCombo.getItems().add("Moderada");
        dificuldadeCombo.getItems().add("Dificil");
    }

    public void showTipoComboBox() {
        tipoCombo.getItems().add("Basic");
        tipoCombo.getItems().add("Premium");
    }

    public void showPartidaComboBox() {
        for (String s : caches.keys()) {
            partidaCombo.getItems().addAll(caches.get(s).getNome());
        }
    }

    public void showDestinoComboBox() {
        for (String s : caches.keys()) {
            destinoCombo.getItems().addAll(caches.get(s).getNome());
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*-------------------------------------- REMOVER ITEMS DAS TABELAS ----------------------------------------------*/

    public void handleRemoveUserAction(ActionEvent actionEvent) throws IOException {
        Utilizador user = usersTable.getSelectionModel().getSelectedItem();
        usersTable.getItems().remove(usersTable.getSelectionModel().getSelectedItem());
        if (user instanceof Basic)
            removerBasicUser((Basic) user);
        else if (user instanceof Premium)
            removerPremiumUser((Premium) user);
        else if (user instanceof Admin)
            removerAdminUser((Admin) user);
        usersTable.refresh();
    }

    public void handleRemoveCacheAction(ActionEvent actionEvent) throws IOException {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        geocachesTable.getItems().remove(geocachesTable.getSelectionModel().getSelectedItem());
        caches.delete(cache.getNome());
        geocachesTable.refresh();
        atualizarLogs();
    }

    public void handleRemoveTravelBugAction(ActionEvent actionEvent) throws IOException {
        TravelBug tb = travelbugsTable.getSelectionModel().getSelectedItem();
        travelbugsTable.getItems().remove(travelbugsTable.getSelectionModel().getSelectedItem());
        travelbugs.delete(tb.getNome());
        travelbugsTable.refresh();
        atualizarHistoricoTB();
    }

    public void handleRemoveLogTravelBugAction(ActionEvent actionEvent) throws IOException {
        Log log = historicoTable.getSelectionModel().getSelectedItem();
        historicoTable.getItems().remove(historicoTable.getSelectionModel().getSelectedItem());
        travelbugs.get(log.getCacheTravelBug()).getHistorico().delete(log.getId());
        historicoTable.refresh();
    }

    public void handleRemoveLogCacheAction(ActionEvent actionEvent) throws IOException {
        Log log = logsTable.getSelectionModel().getSelectedItem();
        logsTable.getItems().remove(logsTable.getSelectionModel().getSelectedItem());
        caches.get(log.getCacheTravelBug()).getLogs().delete(log.getId());
        logsTable.refresh();
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------- EDITAR ITEMS DA TABELA USERS ----------------------------------------------*/

    public void handleEditarUserId(TableColumn.CellEditEvent editedcell) {
        Utilizador user = usersTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) return;
        int aux = Integer.parseInt(editedcell.getNewValue().toString());
        if (basics.get(aux) == null && admins.get(aux) == null && premiums.get(aux) == null) {
            if (user.getPerm().equals("premium")) {
                premiums.delete(user.getID());
                user.setID(aux);
                premiums.put(user.getID(), (Premium) user);
            } else if (user.getPerm().equals("admin")) {
                admins.delete(user.getID());
                user.setID(aux);
                admins.put(user.getID(), (Admin) user);
            } else if (user.getPerm().equals("basic")) {
                basics.delete(user.getID());
                user.setID(aux);
                basics.put(user.getID(), (Basic) user);
            }
            listarBasicUsers();
            listarPremiumUsers();
            listarAdminUsers();
        } else {
            Alert("Utilizador", null, "ID do user ja consta na DB!");
        }
    }

    public void handleEditarUserNome(TableColumn.CellEditEvent editedcell) {
        Utilizador user = usersTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) return;
        user.setNome(editedcell.getNewValue().toString());
        int aux = Integer.parseInt(editedcell.getNewValue().toString());

    }

    public void handleEditarUserTipo(TableColumn.CellEditEvent editedcell) {
        Utilizador user = usersTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) return;
        if (editedcell.getNewValue().toString().equals("premium") ||
                editedcell.getNewValue().toString().equals("admin") ||
                editedcell.getNewValue().toString().equals("basic")) {
            user.setNome(editedcell.getNewValue().toString());
        } else {
            Alert("Utilizador",
                    "(basic / premium / admin)", "Tipo de utilizador introduzido é inválido!");
        }
    }

    public void handleEditarUserItems(TableColumn.CellEditEvent editedcell) {
        Utilizador user = usersTable.getSelectionModel().getSelectedItem();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Utilizador> users = new ArrayList<>();
        if (editedcell.getNewValue().toString().equals("")) {
            user.setItems(items);
        } else {
            String[] s = editedcell.getNewValue().toString().split("; ");
            for (int i = 0; i < s.length; i++) {
                Item item = new Item(s[i]);
                items.add(item);
            }
            user.setItems(items);
        }
        for (int i : basics.keys())
            users.add(basics.get(i));
        for (int i : premiums.keys())
            users.add(premiums.get(i));
        for (int i : admins.keys())
            users.add(admins.get(i));
        usersTable.getItems().clear();
        usersTable.getItems().addAll(users);
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------- EDITAR ITEMS DA TABELA CACHES ---------------------------------------------*/

    public void handleEditarCacheNome(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals("")) || caches.contains(editedcell.getNewValue().toString())) {
            Alert("Cache", null, "Nome da Cache introduzida já consta na DB!");
            return;
        }
        caches.delete(cache.getNome());
        cache.setNome(editedcell.getNewValue().toString());
        caches.put(cache.getNome(), cache);
        atualizarLogs();
    }

    public void handleEditarCacheTipo(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) return;
        if (editedcell.getNewValue().toString().equals("premium") || editedcell.getNewValue().toString().equals("basic")) {
            cache.setTipo(editedcell.getNewValue().toString());
        } else {
            Alert("Cache", "(basic / premium)", "Tipo da Cache introduzido é inválido!");
        }
    }

    public void handleEditarCacheRegiao(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) return;
        if (editedcell.getNewValue().toString().equals("Norte") || editedcell.getNewValue().toString().equals("Sul")
                || editedcell.getNewValue().toString().equals("Centro")) {
            cache.setRegiao(editedcell.getNewValue().toString());
        } else {
            Alert("Cache", "(Norte / Centro / Sul)", "Regiao da Cache introduzida é inválida!");
        }
    }

    public void handleEditarCacheX(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) {
            Alert("Cache", null, "Coordenada intoduzida inválida!");
            return;
        }
        cache.setLatitude(Float.parseFloat(editedcell.getNewValue().toString()));
    }

    public void handleEditarCacheY(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        if (editedcell.getNewValue().toString().equals("")) {
            Alert("Cache", null, "Coordenada intoduzida inválida!");
            return;
        }
        cache.setLongitude(Float.parseFloat(editedcell.getNewValue().toString()));
    }

    public void handleEditarCacheItems(TableColumn.CellEditEvent editedcell) {
        Cache cache = geocachesTable.getSelectionModel().getSelectedItem();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Cache> cachesAL = new ArrayList<>();
        if (editedcell.getNewValue().toString().equals("")) {
            cache.setItems(items);
        } else {
            String[] s = editedcell.getNewValue().toString().split("; ");
            for (int i = 0; i < s.length; i++) {
                Item item = new Item(s[i]);
                items.add(item);
            }
            cache.setItems(items);
        }
        for (String s1 : caches.keys())
            cachesAL.add(caches.get(s1));
        geocachesTable.getItems().clear();
        geocachesTable.getItems().addAll(cachesAL);
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------- EDITAR ITEMS DA TABELA TRAVELBUGS -----------------------------------------*/

    public void handleEditarTBNome(TableColumn.CellEditEvent editedcell) {
        TravelBug tb = travelbugsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals("")) ||
                travelbugs.contains(editedcell.getNewValue().toString())) {
            Alert("TravelBug", null, "Nome do TravelBug introduzida já consta na DB!");
            return;
        }
        travelbugs.delete(tb.getNome());
        tb.setNome(editedcell.getNewValue().toString());
        travelbugs.put(tb.getNome(), tb);
        atualizarHistoricoTB();
    }

    public void handleEditarTBUser(TableColumn.CellEditEvent editedcell) {
        int flag = 0;
        TravelBug tb = travelbugsTable.getSelectionModel().getSelectedItem();
        for (int i : basics.keys())
            if (basics.get(i).getNome().equals(editedcell.getNewValue().toString())) {
                Alert("TravelBug", null, "Utilizador introduzido não pode criar TravelBugs!");
                return;
            }
        for (int i : premiums.keys())
            if (premiums.get(i).getNome().equals(editedcell.getNewValue().toString())) flag++;
        for (int i : admins.keys())
            if (admins.get(i).getNome().equals(editedcell.getNewValue().toString())) flag++;
        if ((editedcell.getNewValue().toString().equals("")) || flag == 0) {
            Alert("TravelBug", null, "Nome de Utilizador introduzido inválido!");
            return;
        }
        tb.setNomeCriador(editedcell.getNewValue().toString());
    }

    public void handleEditarTBCache(TableColumn.CellEditEvent editedcell) {
        TravelBug tb = travelbugsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals("")) ||
                !caches.contains(editedcell.getNewValue().toString())) {
            Alert("TravelBug", null, "Nome da Cache introduzido inválido!");
            return;
        }
        tb.setCacheInicial(editedcell.getNewValue().toString());
    }

    public void handleEditarTBObjetivo(TableColumn.CellEditEvent editedcell) {
        TravelBug tb = travelbugsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals(""))) {
            Alert("TravelBug", null, "Objetivo introduzido inválido!");
            return;
        }
        tb.setObjetivo(editedcell.getNewValue().toString());
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------- EDITAR ITEMS DA TABELA DE LOGS ------------------------------------------*/

    public void handleEditarGeocacheLog(TableColumn.CellEditEvent editedcell) {
        Log log = logsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals("")) || !caches.contains(editedcell.getNewValue().toString())) {
            Alert("Log", null, "Nome do Cache introduzida não consta na DB!");
            return;
        }
        caches.get(log.getCacheTravelBug()).removelogs(log);
        caches.get(editedcell.getNewValue().toString()).addLogs(log);
    }

    public void handleEditarInfoLog(TableColumn.CellEditEvent editedcell) {
        Log log = logsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals(""))) {
            Alert("Log", null, "Por favor preencha o campo que se encontra vazio!");
            return;
        }
        log.setInfo(editedcell.getNewValue().toString());
    }

    public void handleEditarMensagemLog(TableColumn.CellEditEvent editedcell) {
        Log log = logsTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals(""))) {
            log.setMensagem(null);
            return;
        }
        log.setMensagem(editedcell.getNewValue().toString());
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------- EDITAR ITEMS DA TABELA DE HISTORICO ---------------------------------------*/

    public void handleEditarGeocacheHistorico(TableColumn.CellEditEvent editedcell) {
        Log historico = historicoTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals("")) || !travelbugs.contains(editedcell.getNewValue().toString())) {
            Alert("Historico", null, "Nome do TravelBug introduzido não consta na DB!");
            return;
        }
        travelbugs.get(historico.getCacheTravelBug()).getHistorico().delete(historico.getId());
        travelbugs.get(editedcell.getNewValue().toString()).getHistorico().put(historico.getId(), historico);
    }

    public void handleEditarInfoHistorico(TableColumn.CellEditEvent editedcell) {
        Log historico = historicoTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals(""))) {
            Alert("Historico", null, "Por favor preencha o campo que se encontra vazio!");
            return;
        }
        historico.setInfo(editedcell.getNewValue().toString());
    }

    public void handleEditarMensagemHistorico(TableColumn.CellEditEvent editedcell) {
        Log historico = historicoTable.getSelectionModel().getSelectedItem();
        if ((editedcell.getNewValue().toString().equals(""))) {
            historico.setMensagem(null);
            return;
        }
        historico.setMensagem(editedcell.getNewValue().toString());
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------- ADICIONAR ITEMS NAS TABELAS ------------------------------------------*/

    public void handleAdicionarUtilizador(ActionEvent actionEvent) {
        if (nomeUtilizadoresTextField.getText().isEmpty() || tipoUtilizadoresTextField.getText().isEmpty()) {
            Alert("Utilizador", null, "Por favor preencha o campo que se encontra vazio!");
        } else {
            ArrayList<Item> Items = new ArrayList<>();
            if (!itemsUtilizadoresTextField.getText().isEmpty()) {

                String[] s = itemsUtilizadoresTextField.getText().split("; ");
                for (int i = 0; i < s.length; i++) {
                    Item item = new Item(s[i]);
                    Items.add(item);
                }
            }
            if (tipoUtilizadoresTextField.getText().equals("basic")) {
                Basic b = new Basic(nomeUtilizadoresTextField.getText(), tipoUtilizadoresTextField.getText());
                basics.put(b.getID(), b);
                b.setItems(Items);
                usersTable.getItems().add(b);
            } else if (tipoUtilizadoresTextField.getText().equals("premium")) {
                Premium p = new Premium(nomeUtilizadoresTextField.getText(), tipoUtilizadoresTextField.getText());
                premiums.put(p.getID(), p);
                p.setItems(Items);
                usersTable.getItems().add(p);
            } else if (tipoUtilizadoresTextField.getText().equals("admin")) {
                Admin a = new Premium(nomeUtilizadoresTextField.getText(), tipoUtilizadoresTextField.getText());
                admins.put(a.getID(), a);
                a.setItems(Items);
                usersTable.getItems().add(a);
            } else
                Alert("Utilizador", "(basic / premium / admin)", "Tipo de Utilizador inválido");
            nomeUtilizadoresTextField.clear();
            tipoUtilizadoresTextField.clear();
            itemsUtilizadoresTextField.clear();
        }
    }

    public void handleAdicionarCache(ActionEvent actionEvent) {
        if (nomeGeocachesTextField.getText().isEmpty() || tipoGeocachesTextField.getText().isEmpty()
                || xGeocachesTextField.getText().isEmpty() || yGeocachesTextField.getText().isEmpty()
                || regiaoGeocachesTextField.getText().isEmpty()) {
            Alert("Cache", null, "Por favor preencha o/s campo/s que se encontra/m vazio!");
        } else {
            ArrayList<Item> Items = new ArrayList<>();
            if (!itemsGeocachesTextField.getText().isEmpty()) {
                String[] s = itemsGeocachesTextField.getText().split("; ");
                for (int i = 0; i < s.length; i++) {
                    Item item = new Item(s[i]);
                    Items.add(item);
                }
            }
            if (!caches.contains(nomeGeocachesTextField.getText())){
                Cache c = new Cache(nomeGeocachesTextField.getText(), regiaoGeocachesTextField.getText(),
                        Float.parseFloat(xGeocachesTextField.getText()),
                        Float.parseFloat(yGeocachesTextField.getText()),
                        null, null, tipoGeocachesTextField.getText());
                caches.put(c.getNome(), c);
                c.setItems(Items);
                geocachesTable.getItems().add(c);
            }
            else Alert("Cache", null, "Cache introduzida já consta na DB!");
            nomeGeocachesTextField.clear();
            tipoGeocachesTextField.clear();
            xGeocachesTextField.clear();
            yGeocachesTextField.clear();
            regiaoGeocachesTextField.clear();
            itemsGeocachesTextField.clear();
        }
    }

    public void handleAdicionarLog(ActionEvent actionEvent) {
        if (dataLogsTextField.getText().isEmpty() || cacheLogsTextField.getText().isEmpty()
                || infoLogsTextField.getText().isEmpty() || mensagemLogsTextField.getText().isEmpty()
        || !caches.contains(cacheLogsTextField.getText())) {
            Alert("Log", null, "Por favor preencha o/s campo/s que se encontra/m vazio!");
        } else {
            String[] s = dataLogsTextField.getText().split(", ");
            if (s.length == 6){
                Date d = new Date(Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                        Integer.parseInt(s[2]), Integer.parseInt(s[3]),
                                Integer.parseInt(s[4]), Integer.parseInt(s[5]));
                Log log = new Log(d, infoLogsTextField.getText(), mensagemLogsTextField.getText());
                caches.get(cacheLogsTextField.getText()).addLogs(log);

                logsTable.getItems().add(log);
            }
            else Alert("Log", "(Ano, mes, dia, hora, minutos, segundos)",
                    "Data de registo inválida!");
            dataLogsTextField.clear();
            cacheLogsTextField.clear();
            infoLogsTextField.clear();
            mensagemLogsTextField.clear();
        }
    }

    public void handleAdicionarHistorico(ActionEvent actionEvent) {
        if (dataHistoricoTBTextField.getText().isEmpty() || travelbugHistoricoTBTextField.getText().isEmpty()
                || infoHistoricoTBTextField.getText().isEmpty() || mensagemHistoricoTBTextField.getText().isEmpty()
                || !travelbugs.contains(travelbugHistoricoTBTextField.getText())) {
            Alert("Historico", null, "Por favor preencha o/s campo/s que se encontra/m vazio!");
        } else {
            String[] s = dataHistoricoTBTextField.getText().split(", ");
            if (s.length == 6){
                Date d = new Date(Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                        Integer.parseInt(s[2]), Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]), Integer.parseInt(s[5]));
                Log historico = new Log(d, infoHistoricoTBTextField.getText(), mensagemHistoricoTBTextField.getText());
                travelbugs.get(travelbugHistoricoTBTextField.getText()).getHistorico().put(historico.getId(),
                        historico);

                historicoTable.getItems().add(historico);
            }
            else Alert("Historico", "(Ano, mes, dia, hora, minutos, segundos)",
                    "Data de registo inválida!");
            dataHistoricoTBTextField.clear();
            travelbugHistoricoTBTextField.clear();
            infoHistoricoTBTextField.clear();
            mensagemHistoricoTBTextField.clear();
        }
    }

    public void handleAdicionarTravelBug(ActionEvent actionEvent) {
        if (nomeTravelBugsTextField.getText().isEmpty() || userTravelBugsTextField.getText().isEmpty()
                || cacheTravelBugsTextField.getText().isEmpty() || objetivoTravelBugsTextField.getText().isEmpty()) {
            Alert("TravelBug", null, "Por favor preencha o/s campo/s que se encontra/m vazio!");
        } else {
            if (!travelbugs.contains(nomeTravelBugsTextField.getText())){
                TravelBug tb = new TravelBug(nomeTravelBugsTextField.getText(), userTravelBugsTextField.getText(),
                        null, 0.0f, 0.0f, cacheTravelBugsTextField.getText(),
                        objetivoTravelBugsTextField.getText());
                travelbugs.put(tb.getNome(), tb);

                travelbugsTable.getItems().add(tb);
            }
            else Alert("TravelBug", null, "TravelBug introduzido já consta na DB!");
            nomeTravelBugsTextField.clear();
            userTravelBugsTextField.clear();
            cacheTravelBugsTextField.clear();
            objetivoTravelBugsTextField.clear();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------- FUNÇÔES AUXILIARES ------------------------------------------------*/

    public void Alert(String Title, String Info, String Header) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle(Title);
        a1.setContentText(Info);
        a1.setHeaderText(Header);
        a1.showAndWait();
    }

    public ArrayList<Log> atualizarLogs() {
        ArrayList<Log> LogsCache = new ArrayList<>();
        for (String s : caches.keys()) {
            if (!caches.get(s).getLogs().isEmpty())
                for (int i : caches.get(s).getLogs().keys())
                    LogsCache.add(caches.get(s).getLogs().get(i));
        }
        logsTable.getItems().clear();
        logsTable.getItems().addAll(LogsCache);
        logsTable.refresh();
        return LogsCache;
    }

    public ArrayList<Log> atualizarHistoricoTB() {
        ArrayList<Log> LogsTravelBug = new ArrayList<>();
        for (String s : travelbugs.keys()) {
            if (!travelbugs.get(s).getHistorico().isEmpty())
                for (int i : travelbugs.get(s).getHistorico().keys())
                    LogsTravelBug.add(travelbugs.get(s).getHistorico().get(i));
        }
        historicoTable.getItems().clear();
        historicoTable.getItems().addAll(LogsTravelBug);
        historicoTable.refresh();

        return LogsTravelBug;
    }

    /*---------------------------------------------------------------------------------------------------------------*/
       /* public void saveBinGraph(SymbolDigraphWeighted g, String path) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
                oos.writeObject(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public SymbolDigraphWeighted readBinGraph(SymbolDigraphWeighted g, String path) {
            ObjectInputStream ios = null;
            try {
                ios = new ObjectInputStream(new FileInputStream(new File(path)));
                g = (SymbolDigraphWeighted) ios.readObject();
                return g;
    //            System.out.println(g.digraph());
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            return null;
        }*/

    public void handleGerarGrafoCache() {
        graphPane.getChildren().clear();
        for (Node n : Geocaching.getAllNodes()) {
            gerarVerticesCacheGraph(n.getC());
        }
        for (Node n : Geocaching.getAllNodes()) {
            gerarLinhasCache(n);
        }
    }

    public void gerarLinhasCache(Node n) {
        for (EdgeDoubleWeighted edge : Geocaching.getAllEdgesFromNode(n)) {
            if (n.compareTo(Geocaching.getNode(edge.getW())) != 0) {
                StackPane spv = (StackPane) graphPane.getChildren().get(edge.getV());
                Circle cv = (Circle) spv.getChildren().get(0);
                StackPane spw = (StackPane) graphPane.getChildren().get(edge.getW());
                Circle cw = (Circle) spw.getChildren().get(0);
                System.out.println("circle = " + cw.getCenterX());
                Line line = new Line(cv.getCenterX(), cv.getCenterY(), cw.getCenterX(), cw.getCenterY());
                line.setStrokeWidth(2.0);
                graphPane.getChildren().add(line);
            }
        }
    }

    public void gerarVerticesCacheGraph(Cache cache) {
        String name = cache.getNome();
        CoordenadasVertices cv = new CoordenadasVertices(cache.getGPS().getLatitude(), cache.getGPS().getLongitude());
        double posX = cv.getX();
        double posY = cv.getY();

        Circle c = new Circle(posX, posY, radius);
        c.setOpacity(0.3);
        if (cache.getTipo().equals("basic")) c.setFill(Color.BLACK);
        else c.setFill(Color.RED);
        c.setId("" + p++);
        Text text = new Text("" + name);
        StackPane stack = new StackPane();
        //stack.setPadding(new Insets(100, 0, 0, 500));
        stack.setLayoutX(posX);
        stack.setLayoutY(posY);
        stack.getChildren().addAll(c, text);
        graphPane.getChildren().add(stack);
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    public Geocaching<Node> handleGerarEvitarGrafoCache(String Zona, String Dificuldade, Integer nVisitantes) {
        Geocaching<Node> geocache = Geocaching;


        if (Zona != null) {
            for (Node n : geocache.getAllNodes()) {
                if ((n.getC().getRegiao()).equals(Zona)) {
                    geocache.getNodes().getSt().delete(n);
                    geocache.setG(geocache.getNodes().graph());
                }
            }
        }
        if (Dificuldade != null) {
            for (Node n : geocache.getAllNodes()) {
                if ((n.getC().getRegiao().equals(Dificuldade))) geocache.getNodes().getSt().delete(n);
            }
        }
        if (nVisitantes != null) {
            for (Node n : geocache.getAllNodes()) {
                int k = listarUtilizadoresCache(n.getC());
                if (k < nVisitantes) geocache.getNodes().getSt().delete(n);
            }
        }
        for (Node n : geocache.getAllNodes()) {
            System.out.println("Node : " + n.getC().getNome() + " Regiao: " + n.getC().getRegiao());
        }
        return geocache;
    }

    /*---------------------------------------------------------------------------------------------------------------*/
}