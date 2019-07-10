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
import network.Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class JoinServer extends Application
{
    private ImageView imageView;
    private Image strongholdImg;
    private MediaPlayer mediaPlayer;
    private Media strongholdTrk;
    static DataInputStream in;
  //  public static ArrayList<ClientHandler> clients = new ArrayList<>();

    @Override
    public void start(Stage stage)
    {
        initUI(stage);
    }

    private void initUI(Stage stage)
    {
        // Creating a pane.
        Pane root = new Pane();

        // Setting labels, text fields and buttons.
        Label lbl1 = new Label("Enter Server IP:");
        Label lbl2 = new Label("Enter your username:");
        TextField txtFld1 = new TextField();
        TextField txtFld2 = new TextField();
        Button btnOk = new Button("_Ok");
        Button btnBack = new Button("_Back");
        Button btnQuit = new Button("_Quit");

        // Setting labels fonts and colors.
        lbl1.setFont(Font.font("Serif", FontWeight.BOLD, 20));
        lbl1.setTextFill(Color.WHITE);
        lbl2.setFont(Font.font("Serif", FontWeight.BOLD, 20));
        lbl2.setTextFill(Color.WHITE);

        // Setting Text fields sizes.
        txtFld1.setPrefWidth(120);
        txtFld2.setPrefWidth(120);

        // Setting actions of buttons.
        btnOk.setOnAction((ActionEvent event) ->
        {
            if (!(txtFld2.getText().equals("")))
            {
                String name = txtFld2.getText();
                System.out.println((CreateServer.ip));
                if (txtFld1.getText().equals(CreateServer.ip))
                {
                    // Creating a stage for error.
                    Stage stageS = new Stage();

                    // Creating a Pane for error.
                    Pane rootS = new Pane();

                    // Setting a label and button.
                    Label lblS = new Label("Do you want to start game?");
                    Button btnYes = new Button("_Yes");
                    Button btnNo = new Button("_No");

                    // Setting label font.
                    lblS.setFont(Font.font("Serif", FontWeight.BOLD, 25));

                    // Setting the sizes of buttons.
                    btnYes.setPrefWidth(80);
                    btnNo.setPrefWidth(80);

                    // Setting buttons actions.
                    btnYes.setOnAction((ActionEvent e) ->
                    {
                            try
                            {
                                String ip = in.readUTF();
                                System.out.println(ip);
                                Socket socket = new Socket(CreateServer.ip, 8888);
                                Client client = new Client(name, socket);
                                ClientHandler clientHandler = new ClientHandler(client);
                                System.out.println(clientHandler.name);
                                CreateServer.clients.execute(clientHandler);
                                stage.close();
                                //game should be played
                            }
                            catch (IOException r)
                            {
                                r.printStackTrace();
                            }
                            stageS.close();


                     //   CreateServer.flag = false;
                        //enter game stage
//                        for(ClientHandler client : CreateServer.clients)
//                        {
//                            new Thread(client).start();
//                        }
                        mediaPlayer.stop();

                    });
                    btnNo.setOnAction((ActionEvent e) -> {
                        stageS.close();
                    });

                    // Setting Positions.
                    lblS.setLayoutX(15);
                    lblS.setLayoutY(30);
                    btnYes.setLayoutX(65);
                    btnYes.setLayoutY(100);
                    btnNo.setLayoutX(155);
                    btnNo.setLayoutY(100);

                    // Adding label and button.
                    rootS.getChildren().addAll(lblS, btnYes, btnNo);

                    // Creating a scene
                    Scene sceneError = new Scene(rootS, 300, 150);

                    // Setting title and scene for the stage and disabling changing its size.
                    stageS.setTitle("Start");
                    stageS.setScene(sceneError);
                    stageS.setResizable(false);
                    stageS.show();
                }

                else {
                    // Creating a stage for error.
                    Stage stageError = new Stage();

                    // Creating a Pane for error.
                    Pane rootError = new Pane();

                    // Setting a label and button.
                    Label lblError = new Label("IP not found!!!");
                    Button secondaryBtnOk = new Button("_Ok");

                    // Setting label font.
                    lblError.setFont(Font.font("Serif", FontWeight.BOLD, 40));

                    // Setting the size of button.
                    secondaryBtnOk.setPrefWidth(80);

                    // Setting button action.
                    secondaryBtnOk.setOnAction((ActionEvent e) -> {
                        stageError.close();
                    });

                    // Setting Positions.
                    lblError.setLayoutX(25);
                    lblError.setLayoutY(30);
                    secondaryBtnOk.setLayoutX(110);
                    secondaryBtnOk.setLayoutY(100);

                    // Adding label and button.
                    rootError.getChildren().addAll(lblError, secondaryBtnOk);

                    // Creating a scene
                    Scene sceneError = new Scene(rootError, 300, 150);

                    // Setting title and scene for the stage and disabling changing its size.
                    stageError.setTitle("Error");
                    stageError.setScene(sceneError);
                    stageError.setResizable(false);
                    stageError.show();
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
                secondaryBtnOk.setOnAction((ActionEvent e) -> {
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
        btnBack.setOnAction((ActionEvent event) -> {
            mediaPlayer.stop();
            GameEntry gameEntry = new GameEntry();
            gameEntry.start(stage);
        });
        btnQuit.setOnAction((ActionEvent event) -> {Platform.exit();});

        // setting positions.
        lbl1.setLayoutX(50);
        lbl1.setLayoutY(62);
        lbl2.setLayoutX(50);
        lbl2.setLayoutY(102);
        txtFld1.setLayoutX(200);
        txtFld1.setLayoutY(60);
        txtFld2.setLayoutX(250);
        txtFld2.setLayoutY(100);
        btnOk.setLayoutX(325);
        btnOk.setLayoutY(60);
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

        // Adding image, labels, text fields and buttons.
        root.getChildren().addAll(imageView, lbl1, lbl2, txtFld1, txtFld2, btnOk, btnBack, btnQuit);

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
        strongholdImg = new Image("/menu/StrongholdJoinServerImage.jpg");
    }

    private void loadMusic()
    {
        strongholdTrk = new Media(getClass().getResource("/menu/StrongholdJoinServerTrack.mp3").toString());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
