package menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameEntry extends Application
{
    private ImageView imageView;
    private Image strongholdImg;
    private MediaPlayer mediaPlayer;
    private Media strongholdTrk;

    @Override
    public void start(Stage stage)
    {
        initUI(stage);
    }

    private void initUI(Stage stage)
    {
        // Creating a Pane.
        Pane root = new Pane();

        // Creating buttons.
        Button btnCS = new Button("_Create Server");
        Button btnJS = new Button("_Join Server");
        Button btnQuit = new Button("_Quit");

        // Setting <Join Server> button size.
        btnJS.setPrefWidth(115);

        // Creating Tooltips for buttons and assigning them to the considered buttons.
        Tooltip btnCSTip = new Tooltip("Create a server in case others can join.");
        Tooltip btnJSTip = new Tooltip("Join a created server.");
        Tooltip.install(btnCS, btnCSTip);
        Tooltip.install(btnJS, btnJSTip);

        // Setting actions of buttons.
        btnCS.setOnAction((ActionEvent event) -> {
            mediaPlayer.stop();
            CreateServer createServer = new CreateServer();
            createServer.
                    start(stage);
        });
        btnJS.setOnAction((ActionEvent event) -> {
            mediaPlayer.stop();
            JoinServer joinServer = new JoinServer();
            joinServer.start(stage);
        });
        btnQuit.setOnAction((ActionEvent event) -> {Platform.exit();});

        // setting buttons positions.
        btnCS.setLayoutX(40);
        btnCS.setLayoutY(40);
        btnJS.setLayoutX(40);
        btnJS.setLayoutY(73);
        btnQuit.setLayoutX(700);
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

        // Adding image and buttons.
        root.getChildren().addAll(imageView, btnCS, btnJS, btnQuit);

        // Creating a scene for the stage.
        Scene scene = new Scene(root, 800, 600);

        // Setting title and scene of the stage and disabling changing its size.
        stage.setTitle("Stronghold");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void loadImage()
    {
            strongholdImg = new Image("/menu/StrongholdGameEntryImage.jpg");
    }

    private void loadMusic()
    {
        strongholdTrk = new Media(getClass().getResource("/menu/StrongholdGameEntryTrack.mp3").toString());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
