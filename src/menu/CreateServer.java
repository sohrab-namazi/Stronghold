package menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import network.Client;
import network.ClientHandler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateServer extends Application
{
    static String name;
    private ImageView imageView;
    private Image strongholdImg;
    private MediaPlayer mediaPlayer;
    private Media strongholdTrk;
    static DataOutputStream out;
    static ServerSocket serverSocket;
    static Socket socket;
    public static InetAddress ip;
    static ExecutorService clients = Executors.newFixedThreadPool(2);
  //  public static ArrayList<ClientHandler> clients = new ArrayList<>();
   // static boolean flag = true;
    Stage waitingStage;



    @Override
    public void start(Stage stage)
    {
        initUI(stage);
    }

    private void initUI(Stage stage)
    {
        // Creating a pane.
        Pane root = new Pane();

        // Setting text fields, label and buttons.
        TextField txtFld1 = new TextField();
        TextField txtFld2 = new TextField();
        Label lbl = new Label("Enter your username:");
        Button btnGIP = new Button("_Get IP");
        Button btnSG = new Button("_Start Game");
        Button btnBack = new Button("_Back");
        Button btnQuit = new Button("_Quit");


        // Setting label font and color.
        lbl.setFont(Font.font("Serif", FontWeight.BOLD, 20));
        lbl.setTextFill(Color.WHITE);

        // Setting size of <Get IP> button.
        btnGIP.setPrefWidth(85);

        // Setting the sizes of text fields.
        txtFld1.setPrefWidth(120);
        txtFld2.setPrefWidth(120);

        // Setting actions of buttons.
        btnGIP.setOnAction((ActionEvent event) ->
        {

            try {
                ip = InetAddress.getLocalHost();
                txtFld1.setText(String.valueOf(ip));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        });
        btnSG.setOnAction((ActionEvent event) ->
        {
            if (!(txtFld2.getText().equals("")))
            {
                //i have put loop because maybe later we wanna increase the participants number
                mediaPlayer.stop();
                name = txtFld2.getText();
                //make this stage more appropriate please :)
                waitingStage = new Stage();
                GridPane layout = new GridPane();
                Label label = new Label("Waiting for other player(s)");
                layout.getChildren().addAll(label);
                Scene scene = new Scene(layout);
                waitingStage.setScene(scene);
                waitingStage.setResizable(false);
                waitingStage.setTitle("Waiting Room");
                waitingStage.show();
                try
                {
                    socket = new Socket(ip, 8888);
                    out.writeUTF(String.valueOf(ip));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }



            }

            // if username is not entered.
            else
            {
                // Creating a stage.
                Stage stageUNF = new Stage();

                // Creating a Pane.
                Pane rootUNF = new Pane();

                // Setting a label and button.
                Label lblUNF = new Label("Username not found!!!");
                Button secondaryBtnOk = new Button("_Ok");

                // Setting label font.
                lblUNF.setFont(Font.font("Serif", FontWeight.BOLD, 30));

                // Setting the size of button.
                secondaryBtnOk.setPrefWidth(80);

                // Setting button action.
                secondaryBtnOk.setOnAction((ActionEvent e) ->
                {
                    stageUNF.close();
                });

                // Setting Positions.
                lblUNF.setLayoutX(10);
                lblUNF.setLayoutY(35);
                secondaryBtnOk.setLayoutX(110);
                secondaryBtnOk.setLayoutY(100);

                // Adding label and button.
                rootUNF.getChildren().addAll(lblUNF, secondaryBtnOk);

                // Creating a scene
                Scene sceneError = new Scene(rootUNF, 300, 150);

                // Setting title and scene for the stage and disabling changing its size.
                stageUNF.setTitle("Error");
                stageUNF.setScene(sceneError);
                stageUNF.setResizable(false);
                stageUNF.show();
            }
        });
        btnBack.setOnAction((ActionEvent event) ->
        {
            mediaPlayer.stop();
            GameEntry gameEntry = new GameEntry();
            gameEntry.start(stage);
        });
        btnQuit.setOnAction((ActionEvent event) -> {Platform.exit();});

        // setting positions.
        txtFld1.setLayoutX(140);
        txtFld1.setLayoutY(60);
        txtFld2.setLayoutX(245);
        txtFld2.setLayoutY(100);
        lbl.setLayoutX(50);
        lbl.setLayoutY(102);
        btnGIP.setLayoutX(50);
        btnGIP.setLayoutY(60);
        btnSG.setLayoutX(265);
        btnSG.setLayoutY(60);
        btnBack.setLayoutX(650);
        btnBack.setLayoutY(540);
        btnQuit.setLayoutX(710);
        btnQuit.setLayoutY(540);

        // Setting an image.
        loadImage();
        imageView = new ImageView(strongholdImg);
        imageView.setFitHeight(620);
        imageView.setFitWidth(820);

        // Setting a music track.
        loadMusic();
        mediaPlayer = new MediaPlayer(strongholdTrk);
        mediaPlayer.setAutoPlay(true);

        // Adding image, text field and buttons.
        root.getChildren().addAll(imageView, btnGIP, txtFld1, lbl, txtFld2, btnSG, btnBack, btnQuit);

        // Creating a scene for stage.
        Scene scene = new Scene(root, 800, 600);

        // Setting title and scene of the stage and disabling changing its size.
        stage.setTitle("Stronghold");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void loadImage()
    {
        strongholdImg = new Image("/menu/StrongholdCreateServerImage.jpg");
    }

    private void loadMusic()
    {
        strongholdTrk = new Media(getClass().getResource("/menu/StrongholdCreateServerTrack.mp3").toString());
    }

    public static void main(String[] args)
    {

        new Thread(() ->
        {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8888);
            } catch (IOException e) {
                e.printStackTrace();
            }

                try
                {
                    socket = serverSocket.accept();
                    System.out.println("Connected");
                    Client client = new Client(name, socket);
                    ClientHandler clientHandler = new ClientHandler(client);
                    clients.execute(clientHandler);
                    System.out.println(clientHandler.name);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

        }).start();
       launch(args);



    }
}

