package com.example.projectt;

//In this section we import java libraries.
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;

import static com.example.projectt.alertWarning.display;

//In this section , I code javafx codes
public class Main extends Application
{


    @Override
    public void start(Stage mainPage) {

        //In this section I create all stackpanes.

        StackPane logInRoot = new StackPane();
        StackPane registerRoot = new StackPane();
        StackPane depositStack = new StackPane();
        StackPane root = new StackPane();
        StackPane WidthdrawRoot = new StackPane();
        StackPane PaymentsRoot = new StackPane();
        StackPane cardTransRoot = new StackPane();
        StackPane Amount20Root = new StackPane();
        StackPane Amount50Root = new StackPane();
        StackPane Amount80Root = new StackPane();
        StackPane Amount100Root = new StackPane();
        StackPane Amount150Root = new StackPane();
        StackPane Amount200Root = new StackPane();

        //In this section I create the scenes and I ıntegrate the stackpanes to the scenes
        Scene depositScene = new Scene(depositStack,1000,1000);
        Scene scene = new Scene(logInRoot,1000,1000);
        Scene RegisterScene = new Scene(registerRoot,1000,1000);
        Scene SecondScene = new Scene(root,1000,1000);
        Scene carsScene = new Scene(WidthdrawRoot,1000,1000);
        Scene planesScene= new Scene(PaymentsRoot,1000,1000);
        Scene shipsScene= new Scene(cardTransRoot,1000,1000);
        Scene araba1 = new Scene(Amount20Root,1000,1000);
        Scene araba2 = new Scene(Amount50Root,1000,1000);
        Scene araba3 = new Scene(Amount80Root,1000,1000);
        Scene araba4 = new Scene(Amount100Root,1000,1000);
        Scene araba5 = new Scene(Amount150Root,1000,1000);
        Scene araba6 = new Scene(Amount200Root,1000,1000);

        //Log ın page ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //This is Login Page

        //In this section I add images
        Image imageMainBg = new Image("amblem2.png");
        ImageView iwMainBg = new ImageView(imageMainBg);

        Image imagebgMain = new Image("bg.jpg");
        ImageView iwBgMain = new ImageView(imagebgMain);

        Label ziraatYaziFirst = new Label("Ziraat Bankası");

        ziraatYaziFirst.setStyle("-fx-text-fill: white;-fx-font-size: 60");

        //In this section I write the image's sizes
        iwBgMain.setFitWidth(1000);
        iwBgMain.setFitHeight(1000);

        iwMainBg.setFitWidth(150);
        iwMainBg.setFitHeight(150);

        //In this section I add labels and buttons
        Button btnLogInToReg = new Button("Register");
        Button btnLogIn = new Button("Log In");
        Label lblUsernameTxt = new Label("Account No :");
        Label lblPasswordText = new Label("Card Password :");
        TextField txtUsername = new TextField();
        PasswordField txtPassword = new PasswordField();


        //In this section add the all children structures to the stackpane.And I add all things to the stackpane with using " addAll() " method.
        logInRoot.getChildren().addAll(iwBgMain,iwMainBg,ziraatYaziFirst,btnLogIn,lblPasswordText,lblUsernameTxt,txtUsername,txtPassword,btnLogInToReg);

        //I set the coordinates all structures.
        ziraatYaziFirst.setTranslateY(-350);
        ziraatYaziFirst.setTranslateX(100);
        
        iwMainBg.setTranslateX(-200);
        iwMainBg.setTranslateY(-350);


        logInRoot.setStyle("-fx-background-color: white");

        txtUsername.setMaxSize(200,25);
        txtPassword.setMaxSize(200,25);
        txtUsername.setTranslateX(50);
        txtUsername.setTranslateY(-150);
        txtPassword.setTranslateX(50);
        txtPassword.setTranslateY(-50);

        btnLogInToReg.setMaxSize(75,25);
        btnLogInToReg.setStyle("-fx-text-fill: red");
        btnLogInToReg.setTranslateY(20);

        btnLogIn.setTranslateX(100);
        btnLogIn.setTranslateY(20);
        btnLogIn.setMaxSize(75,25);
        btnLogIn.setStyle("-fx-text-fill: red");

        lblUsernameTxt.setMaxSize(200,75);
        lblUsernameTxt.setTranslateX(-120);
        lblUsernameTxt.setTranslateY(-150);

        //I used the style of the structures . It likes to CSS code syntax
        lblUsernameTxt.setStyle("-fx-font-size: 24;-fx-text-fill: #ffffff;-fx-font-weight: bold");

        lblPasswordText.setMaxSize(200,75);
        lblPasswordText.setTranslateX(-150);
        lblPasswordText.setTranslateY(-50);
        lblPasswordText.setStyle("-fx-font-size: 24;-fx-text-fill: #ffffff;-fx-font-weight: bold");

        //In this section when user click the login button , system will autonticate the inputs and redirect  user to the main page .
        btnLogIn.setOnAction(event -> {
            try {
                File file = new File("src/main/java/com/example/projectt/logs.txt");
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                boolean isLoginSuccess = false;
                String line;

                while ((line = br.readLine()) != null) {
                    String[] split = line.split(",");

                    if (username.equals(split[0]) && password.equals(split[1])) {
                        isLoginSuccess = true;
                        mainPage.setScene(SecondScene);
                        mainPage.show();
                        break;
                    }
                }

                if (!isLoginSuccess) {
                    display("Warning ! " ,"Wrong account no or  password ! ");
                }

                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnLogInToReg.setOnAction(event -> mainPage.setScene(RegisterScene));
        //Register Page ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //In this section I add all stuctures to the stacpanes. And I resize and coordinate all things.
        Image imageGeri = new Image("back.jpg");
        ImageView btnRegisterToLogIn = new ImageView(imageGeri);

        Image bgImageRegister  = new Image("bg.jpg");
        ImageView iwBgRegister = new ImageView(bgImageRegister);

        iwBgRegister.setFitHeight(1000);
        iwBgRegister.setFitWidth(1000);

        Label lblziraatYazi = new Label("Ziraat Bankası");

        lblziraatYazi.setStyle("-fx-text-fill: white;-fx-font-size: 60");
        lblziraatYazi.setTranslateY(-350);
        lblziraatYazi.setTranslateX(100);
        
        Image imageRegisterPage = new Image("amblem2.png");
        ImageView iwRegisterPage = new ImageView(imageRegisterPage);
        iwRegisterPage.setFitWidth(150);
        iwRegisterPage.setFitHeight(150);

        btnRegisterToLogIn.setFitWidth(100);
        btnRegisterToLogIn.setFitHeight(50);

        Label lblUsernameReg = new Label("Account No :");
        Label lblPasswordReg = new Label("Card Password :");
        TextField txtUsernameReg = new TextField();
        TextField txtPasswordReg = new TextField();
        Button btnRegister = new Button("Register");

        registerRoot.getChildren().addAll(iwBgRegister,iwRegisterPage,lblziraatYazi,lblPasswordReg,lblUsernameReg,txtPasswordReg,txtUsernameReg,btnRegister,btnRegisterToLogIn);

        registerRoot.setStyle("-fx-background-color: white");

        iwRegisterPage.setTranslateX(-200);
        iwRegisterPage.setTranslateY(-350);

        txtUsernameReg.setMaxSize(200,25);
        txtPasswordReg.setMaxSize(200,25);
        txtUsernameReg.setTranslateX(50);
        txtUsernameReg.setTranslateY(-150);
        txtPasswordReg.setTranslateX(50);
        txtPasswordReg.setTranslateY(-50);

        lblUsernameReg.setMaxSize(200,75);
        lblUsernameReg.setTranslateX(-120);
        lblUsernameReg.setTranslateY(-150);
        lblUsernameReg.setStyle("-fx-font-size: 24;-fx-text-fill: #ffffff;-fx-font-weight: bold");

        lblPasswordReg.setMaxSize(200,75);
        lblPasswordReg.setTranslateX(-150);
        lblPasswordReg.setTranslateY(-50);
        lblPasswordReg.setStyle("-fx-font-size: 24;-fx-text-fill: #ffffff;-fx-font-weight: bold");

        btnRegisterToLogIn.setTranslateX(-400);
        btnRegisterToLogIn.setTranslateY(-400);

        btnRegister.setStyle("-fx-text-fill: #ff0000;-fx-cell-size: 100 50");
        btnRegister.setTranslateX(50);
        btnRegister.setTranslateY(20);
        btnRegister.setOnAction(actionEvent -> {
            try {
                String username = txtUsernameReg.getText();
                String password = txtPasswordReg.getText();
                File file = new File("logs.txt");

                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);

                if (username.equals("")  || password.equals("")) {
                        display("ERROR !", "Empty Input ! ");
                    }

                     else {
                        String pathLogin = "logs.txt";
                        FileReader fr = new FileReader(pathLogin);
                        BufferedReader br = new BufferedReader(fr);
                        boolean alreadyExists = false;
                        String line;

                        while ((line = br.readLine()) != null) {
                            String[] split = line.split(",");

                            if (username.equals(split[0])) {
                                alreadyExists = true;

                                break;
                            }
                        }
                        if (alreadyExists) {
                            display("ERROR !", "User already exists");

                        }
                        else{
                            bw.write("\n" + username + "," + password);
                            bw.close();
                            display("Succesful", "Succesfully Signed !");
                        }
                        fr.close();
                    }

                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        );
        btnRegisterToLogIn.setOnMouseClicked(e->mainPage.setScene(scene));
        //Main Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image bgImage = new Image("bg.jpg");
        ImageView iwBg = new ImageView(bgImage);

        Button Btnexit = new Button("Exit");

        Label lblziraatYazıMain = new Label("Ziraat Bankası");

        lblziraatYazıMain.setTranslateY(-350);
        lblziraatYazıMain.setTranslateX(100);
        lblziraatYazıMain.setStyle("-fx-text-fill: white;-fx-font-size: 60");

        Image ziraatYazi = new Image("amblem2.png");
        ImageView iwZiraat = new ImageView(ziraatYazi);

        iwZiraat.setFitWidth(150);
        iwZiraat.setFitHeight(150);
        iwZiraat.setTranslateY(-350);
        iwZiraat.setTranslateX(-200);

        Label lblVehicles = new Label("Welcome , please select the action \n you want to do !");
        Button lbl1 = new Button("Withdraw Money");
        Button lbl2 = new Button("Deposit Money");
        Button lbl4 = new Button("Payment Transactions");
        Button lbl5 = new Button("Card Transactions");


        root.getChildren().addAll(iwBg,iwZiraat,lblziraatYazıMain,lblVehicles,lbl1,lbl2,lbl4,lbl5,Btnexit);
        Btnexit.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color: #6c181c ");
        lbl1.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color: #6c181c ");
        lbl2.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color:  #6c181c  ");
        lbl4.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold  ; -fx-background-color:  #6c181c  ");
        lbl5.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");

        lbl1.setOnMouseClicked(e->mainPage.setScene(carsScene));
        lbl2.setOnMouseClicked(e->mainPage.setScene(depositScene));
        lbl4.setOnMouseClicked(e->mainPage.setScene(planesScene));
        lbl5.setOnMouseClicked(e->mainPage.setScene(shipsScene));

        Btnexit.setTranslateX(0);
        Btnexit.setTranslateY(350);
        Btnexit.setMinWidth(250);

        Btnexit.setOnMouseClicked(e->mainPage.setScene(scene));

        iwBg.setFitWidth(1000);
        iwBg.setFitHeight(1000);

        lbl1.setTranslateX(-340);
        lbl2.setTranslateX(-350);

        lbl1.setTranslateY(0);
        lbl2.setTranslateY(150);


        lbl4.setTranslateX(320);
        lbl5.setTranslateX(340);

        lbl4.setTranslateY(0);
        lbl5.setTranslateY(150);

        root.setStyle("-fx-background-color: #c5311b");

        lblVehicles.setTranslateX(0);
        lblVehicles.setTranslateY(-150);

        lblVehicles.setStyle("-fx-font-size: 35;-fx-text-fill:white;-fx-text-alignment: center");

        mainPage.setResizable(false);

        //Deposit Page Properties----------------------------------------------------------------------------------------------------------------------
        Image depositbgImage = new Image("bg.jpg");
        ImageView depositiwBg = new ImageView(depositbgImage);

        Label lblziraatYazDeposit = new Label("Ziraat Bankası");

        Image depositimageRgGeri1 = new Image("back.jpg");
        ImageView depositbtn1Geri1 = new ImageView(depositimageRgGeri1);

        Image depositziraatYazi = new Image("amblem2.png");
        ImageView depositiwZiraat = new ImageView(depositziraatYazi);

        Label lblDeposit = new Label("Please place the money you want to deposit in the money input section.");

        lblDeposit.setStyle("-fx-font-weight: bold;-fx-text-fill: white;-fx-font-size: 24");

        depositiwZiraat.setFitWidth(150);
        depositiwZiraat.setFitHeight(150);
        depositiwZiraat.setTranslateY(-350);
        depositiwZiraat.setTranslateX(-200);

        depositbtn1Geri1.setTranslateX(-400);
        depositbtn1Geri1.setTranslateY(-400);

        depositbtn1Geri1.setFitWidth(100);
        depositbtn1Geri1.setFitHeight(50);

        lblziraatYazDeposit.setTranslateY(-350);
        lblziraatYazDeposit.setTranslateX(100);
        lblziraatYazDeposit.setStyle("-fx-text-fill: white;-fx-font-size: 60");

        depositStack.getChildren().addAll(depositiwBg,lblziraatYazDeposit,depositbtn1Geri1,depositiwZiraat,lblDeposit);
        depositbtn1Geri1.setOnMouseClicked(e->mainPage.setScene(SecondScene));

        mainPage.setResizable(false);
        //Widthdraw Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageCarsBg = new Image("bg.jpg");
        ImageView iwCarsBg = new ImageView(imageCarsBg);
        iwCarsBg.setFitWidth(1000);
        iwCarsBg.setFitHeight(1000);

        Label witdhrawlbl = new Label("Please enter the amount \n you want to withdraw :");

        witdhrawlbl.setStyle("-fx-text-fill: white;-fx-font-size: 45;-fx-font-weight: bold");
        witdhrawlbl.setTranslateX(0);
        witdhrawlbl.setTranslateY(-300);

        Image imageGeriWid = new Image("back.jpg");
        ImageView btnRegisterToWid = new ImageView(imageGeriWid);

        Button WitdhrawAmount1 = new Button("20 TL");
        Button WitdhrawAmount2 = new Button("50 TL");
        Button WitdhrawAmount3 = new Button("80 TL");
        Button WitdhrawAmount4 = new Button("100 TL");
        Button WitdhrawAmount5 = new Button("150 TL");
        Button WitdhrawAmount6 = new Button("200 TL");

        WitdhrawAmount1.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color: #6c181c ");
        WitdhrawAmount2.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color:  #6c181c  ");
        WitdhrawAmount3.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold ; -fx-background-color:  #6c181c  ");
        WitdhrawAmount4.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold  ; -fx-background-color:  #6c181c  ");
        WitdhrawAmount5.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");
        WitdhrawAmount6.setStyle("-fx-text-fill: white;-fx-font-size: 60;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");

        WidthdrawRoot.getChildren().addAll(iwCarsBg,WitdhrawAmount1,WitdhrawAmount2,witdhrawlbl,WitdhrawAmount3,WitdhrawAmount4,WitdhrawAmount5,WitdhrawAmount6,btnRegisterToWid);

        WitdhrawAmount1.setTranslateX(-350);
        WitdhrawAmount2.setTranslateX(-350);
        WitdhrawAmount3.setTranslateX(-350);

        WitdhrawAmount1.setTranslateY(-100);
        WitdhrawAmount2.setTranslateY(100);
        WitdhrawAmount3.setTranslateY(300);

        WitdhrawAmount4.setTranslateX(350);
        WitdhrawAmount5.setTranslateX(350);
        WitdhrawAmount6.setTranslateX(350);

        WitdhrawAmount4.setTranslateY(-100);
        WitdhrawAmount5.setTranslateY(100);
        WitdhrawAmount6.setTranslateY(300);

        btnRegisterToWid.setTranslateX(-400);
        btnRegisterToWid.setTranslateY(-400);

        btnRegisterToWid.setFitWidth(100);
        btnRegisterToWid.setFitHeight(50);

        btnRegisterToWid.setOnMouseClicked(e->mainPage.setScene(SecondScene));

        WitdhrawAmount1.setOnMouseClicked(e->mainPage.setScene(araba1));
        WitdhrawAmount2.setOnMouseClicked(e->mainPage.setScene(araba2));
        WitdhrawAmount3.setOnMouseClicked(e->mainPage.setScene(araba3));
        WitdhrawAmount4.setOnMouseClicked(e->mainPage.setScene(araba4));
        WitdhrawAmount5.setOnMouseClicked(e->mainPage.setScene(araba5));
        WitdhrawAmount6.setOnMouseClicked(e->mainPage.setScene(araba6));

        //Amount20 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        Image imageAmountBg1 = new Image("bg.jpg");
        ImageView iwAmountBg1 = new ImageView(imageAmountBg1);

        iwAmountBg1.setFitWidth(1000);
        iwAmountBg1.setFitHeight(1000);

        Image ziraatYazi1 = new Image("amblem2.png");
        ImageView iwZiraat1 = new ImageView(ziraatYazi1);

        iwZiraat1.setFitWidth(250);
        iwZiraat1.setFitHeight(250);
        iwZiraat1.setTranslateY(-350);
        iwZiraat1.setTranslateX(0);

        Image imageGeri1 = new Image("back.jpg");
        ImageView btnAraba1Geri1 = new ImageView(imageGeri1);

        Label text1= new Label("The amount you want to withdraw: 20 TL. \n Please do not forget to take your money");

        Amount20Root.getChildren().addAll(iwAmountBg1,btnAraba1Geri1,text1,iwZiraat1);
        text1.setTranslateX(0);
        text1.setTranslateY(0);

        btnAraba1Geri1.setTranslateX(-400);
        btnAraba1Geri1.setTranslateY(-400);
        btnAraba1Geri1.setFitWidth(100);
        btnAraba1Geri1.setFitHeight(50);
        btnAraba1Geri1.setOnMouseClicked(e->mainPage.setScene(carsScene));

        text1.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount20Root.setStyle("-fx-background-color: #f0d044");

        //Amount50 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageAmountBg2 = new Image("bg.jpg");
        ImageView iwAmountBg2 = new ImageView(imageAmountBg2);

        iwAmountBg2.setFitWidth(1000);
        iwAmountBg2.setFitHeight(1000);

        Image ziraatYazi2 = new Image("amblem2.png");
        ImageView iwZiraat2 = new ImageView(ziraatYazi2);

        iwZiraat2.setFitWidth(250);
        iwZiraat2.setFitHeight(250);
        iwZiraat2.setTranslateY(-350);
        iwZiraat2.setTranslateX(0);

        Image imageGeri2 = new Image("back.jpg");
        ImageView btnAraba1Geri2 = new ImageView(imageGeri2);

        Label text2= new Label("The amount you want to withdraw: 50 TL. \n Please do not forget to take your money");

        Amount50Root.getChildren().addAll(iwAmountBg2,btnAraba1Geri2,text2,iwZiraat2);
        text2.setTranslateX(0);
        text2.setTranslateY(0);

        btnAraba1Geri2.setTranslateX(-400);
        btnAraba1Geri2.setTranslateY(-400);
        btnAraba1Geri2.setFitWidth(100);
        btnAraba1Geri2.setFitHeight(50);
        btnAraba1Geri2.setOnMouseClicked(e->mainPage.setScene(carsScene));

        text2.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount50Root.setStyle("-fx-background-color: #f0d044");

        //Amount80 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageAmountBg3 = new Image("bg.jpg");
        ImageView iwAmountBg3 = new ImageView(imageAmountBg3);

        iwAmountBg3.setFitWidth(1000);
        iwAmountBg3.setFitHeight(1000);

        Image ziraatYazi3 = new Image("amblem2.png");
        ImageView iwZiraat3 = new ImageView(ziraatYazi3);

        iwZiraat3.setFitWidth(250);
        iwZiraat3.setFitHeight(250);
        iwZiraat3.setTranslateY(-350);
        iwZiraat3.setTranslateX(0);

        Image imageGeri3 = new Image("back.jpg");
        ImageView btnAraba1Geri3 = new ImageView(imageGeri3);

        Label text3= new Label("The amount you want to withdraw: 80 TL. \n Please do not forget to take your money");


        Amount80Root.getChildren().addAll(iwAmountBg3,btnAraba1Geri3,text3,iwZiraat3);
        text3.setTranslateX(0);
        text3.setTranslateY(0);

        btnAraba1Geri3.setTranslateX(-400);
        btnAraba1Geri3.setTranslateY(-400);
        btnAraba1Geri3.setFitWidth(100);
        btnAraba1Geri3.setFitHeight(50);
        btnAraba1Geri3.setOnMouseClicked(e->mainPage.setScene(carsScene));


        text3.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount80Root.setStyle("-fx-background-color: #f0d044");


        //Amount100 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageAmountBg4 = new Image("bg.jpg");
        ImageView iwAmountBg4 = new ImageView(imageAmountBg4);

        iwAmountBg4.setFitWidth(1000);
        iwAmountBg4.setFitHeight(1000);

        Image ziraatYazi4 = new Image("amblem2.png");
        ImageView iwZiraat4 = new ImageView(ziraatYazi4);

        iwZiraat4.setFitWidth(250);
        iwZiraat4.setFitHeight(250);
        iwZiraat4.setTranslateY(-350);
        iwZiraat4.setTranslateX(0);



        Image imageGeri4 = new Image("back.jpg");
        ImageView btnAraba1Geri4 = new ImageView(imageGeri4);

        Label text4= new Label("The amount you want to withdraw: 100 TL. \n Please do not forget to take your money");


        Amount100Root.getChildren().addAll(iwAmountBg4,btnAraba1Geri4,text4,iwZiraat4);
        text4.setTranslateX(0);
        text4.setTranslateY(0);

        btnAraba1Geri4.setTranslateX(-400);
        btnAraba1Geri4.setTranslateY(-400);
        btnAraba1Geri4.setFitWidth(100);
        btnAraba1Geri4.setFitHeight(50);
        btnAraba1Geri4.setOnMouseClicked(e->mainPage.setScene(carsScene));


        text4.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount100Root.setStyle("-fx-background-color: #f0d044");

        //Amount150 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageAmountBg5 = new Image("bg.jpg");
        ImageView iwAmountBg5 = new ImageView(imageAmountBg5);

        iwAmountBg5.setFitWidth(1000);
        iwAmountBg5.setFitHeight(1000);

        Image ziraatYazi5 = new Image("amblem2.png");
        ImageView iwZiraat5 = new ImageView(ziraatYazi5);

        iwZiraat5.setFitWidth(250);
        iwZiraat5.setFitHeight(250);
        iwZiraat5.setTranslateY(-350);
        iwZiraat5.setTranslateX(0);



        Image imageGeri5 = new Image("back.jpg");
        ImageView btnAraba1Geri5 = new ImageView(imageGeri5);

        Label text5= new Label("The amount you want to withdraw: 150 TL. \n Please do not forget to take your money");


        Amount150Root.getChildren().addAll(iwAmountBg5,btnAraba1Geri5,text5,iwZiraat5);
        text5.setTranslateX(0);
        text5.setTranslateY(0);

        btnAraba1Geri5.setTranslateX(-400);
        btnAraba1Geri5.setTranslateY(-400);
        btnAraba1Geri5.setFitWidth(100);
        btnAraba1Geri5.setFitHeight(50);
        btnAraba1Geri5.setOnMouseClicked(e->mainPage.setScene(carsScene));


        text5.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount150Root.setStyle("-fx-background-color: #f0d044");

        //Amount200 Page Properties ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Image imageAmountBg6 = new Image("bg.jpg");
        ImageView iwAmountBg6 = new ImageView(imageAmountBg6);

        iwAmountBg6.setFitWidth(1000);
        iwAmountBg6.setFitHeight(1000);

        Image ziraatYazi6 = new Image("amblem2.png");
        ImageView iwZiraat6 = new ImageView(ziraatYazi6);

        iwZiraat6.setFitWidth(250);
        iwZiraat6.setFitHeight(250);
        iwZiraat6.setTranslateY(-350);
        iwZiraat6.setTranslateX(0);



        Image imageGeri6 = new Image("back.jpg");
        ImageView btnAraba1Geri6 = new ImageView(imageGeri6);

        Label text6= new Label("The amount you want to withdraw: 200 TL. \n Please do not forget to take your money");


        Amount200Root.getChildren().addAll(iwAmountBg6,btnAraba1Geri6,text6,iwZiraat6);
        text6.setTranslateX(0);
        text6.setTranslateY(0);

        btnAraba1Geri6.setTranslateX(-400);
        btnAraba1Geri6.setTranslateY(-400);
        btnAraba1Geri6.setFitWidth(100);
        btnAraba1Geri6.setFitHeight(50);
        btnAraba1Geri6.setOnMouseClicked(e->mainPage.setScene(carsScene));


        text6.setStyle("-fx-text-fill: white ;-fx-font-size: 30;-fx-font-weight: bold");
        Amount200Root.setStyle("-fx-background-color: #f0d044");



        //Payments Page Properties -------------------------------------------------------------------------------------------
        Image imagePlanesBg = new Image("bg.jpg");
        ImageView iwPlanesBg = new ImageView(imagePlanesBg);
        iwPlanesBg.setFitWidth(1000);
        iwPlanesBg.setFitHeight(1000);

        Image imagePlanes = new Image("back.jpg");
        ImageView btnPlanesGeri = new ImageView(imagePlanes);

        Button btnPayments1 = new Button("Bill Payments");
        Button btnPayments2 = new Button("SSI Payments");
        Button btnPayments3 = new Button("Tuition Payments");
        Button btnPayments4 = new Button("Tax Payments");
        Button btnPayments5 = new Button("Title Deed Payments");
        Button btnPayments6 = new Button("Institution Payments");

        btnPayments1.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color: #6c181c ");
        btnPayments2.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-text-alignment: left;-fx-background-color:  #6c181c  ");
        btnPayments3.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold  ; -fx-background-color:  #6c181c  ");
        btnPayments4.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");
        btnPayments5.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");
        btnPayments6.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;-fx-background-color:  #6c181c  ");

        PaymentsRoot.getChildren().addAll(iwPlanesBg,btnPayments1,btnPayments2,btnPayments3,btnPayments4,btnPayments5,btnPayments6,btnPlanesGeri);

        btnPlanesGeri.setFitWidth(100);
        btnPlanesGeri.setFitHeight(100);

        btnPayments1.setTranslateX(-340);
        btnPayments2.setTranslateX(-340);
        btnPayments3.setTranslateX(-310);

        btnPayments1.setTranslateY(50);
        btnPayments2.setTranslateY(200);
        btnPayments3.setTranslateY(350);


        btnPayments4.setTranslateX(340);
        btnPayments5.setTranslateX(300);
        btnPayments6.setTranslateX(300);

        btnPayments4.setTranslateY(50);
        btnPayments5.setTranslateY(200);
        btnPayments6.setTranslateY(350);

        btnPlanesGeri.setTranslateX(-400);
        btnPlanesGeri.setTranslateY(-350);

        btnPlanesGeri.setOnMouseClicked(e->mainPage.setScene(SecondScene));

        // Card Trans Properties -------------------------------------------------------------------------------------------
        Image bgImageCardTrans = new Image("bg.jpg");
        ImageView iwBgCardTrans = new ImageView(bgImageCardTrans);

        Image imageRgGeriCardTrans1 = new Image("back.jpg");
        ImageView btn1GeriCardTrans1 = new ImageView(imageRgGeriCardTrans1);

        Label lblziraatYazıCardTrans = new Label("Ziraat Bankası");

        lblziraatYazıCardTrans.setTranslateY(-350);
        lblziraatYazıCardTrans.setTranslateX(100);
        lblziraatYazıCardTrans.setStyle("-fx-text-fill: white;-fx-font-size: 60");

        Image ziraatYaziCardTrans = new Image("amblem2.png");
        ImageView iwZiraatCardTrans = new ImageView(ziraatYaziCardTrans);

        iwZiraatCardTrans.setFitWidth(150);
        iwZiraatCardTrans.setFitHeight(150);
        iwZiraatCardTrans.setTranslateY(-350);
        iwZiraatCardTrans.setTranslateX(-200);


        Label labelSorry = new Label("Sorry, we are unable to process \n card transactions at this time.");

        labelSorry.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold");

        cardTransRoot.getChildren().addAll(iwBgCardTrans,iwZiraatCardTrans  ,lblziraatYazıCardTrans,btn1GeriCardTrans1,labelSorry);

        iwBgCardTrans.setFitWidth(1000);
        iwBgCardTrans.setFitHeight(1000);

        btn1GeriCardTrans1.setTranslateX(-400);
        btn1GeriCardTrans1.setTranslateY(-400);

        btn1GeriCardTrans1.setFitWidth(100);
        btn1GeriCardTrans1.setFitHeight(50);

        btn1GeriCardTrans1.setOnMouseClicked(e->mainPage.setScene(SecondScene));

        mainPage.setResizable(false);

        mainPage.setTitle("Ziraat Bankası");
        mainPage.setScene(scene);
        mainPage.show();
    }

    public static void main(String[] args)
    {
        launch(args);

    }
}

