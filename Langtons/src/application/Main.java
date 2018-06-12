package application;

import ant.Ant;
import board.Tile;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	public static GridPane root;

	public static int width = 1080;
	public static int height = 1920;
	public static Tile[][] boardy = new Tile[width][height];;

	private ArrayList<Ant> antList = new ArrayList<Ant>();

	private Ant ant1 = new Ant(1, 0, 15, 20);
	private Ant ant2 = new Ant(2, 3, 50, 80);
	private Ant ant3 = new Ant(3, 3, 65, 23);
	private Ant tester = new Ant(12, 0, 0, 0);

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox();
		
		Scene scene = new Scene(root, 500, 500);
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		primaryStage.setTitle("Langtons Ant");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		primaryStage.setFullScreen(true);

		ant1.setupBoard(width, height);
		ant2.setupBoard(width, height);
		ant3.setupBoard(width, height);
		tester.setupBoard(width, height);

		antList.add(ant1);
		antList.add(ant2);
		antList.add(ant3);

		double cellsize = 1;
		Canvas canvas = new Canvas(width * cellsize, height * cellsize);

		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		new AnimationTimer() {

			@Override
			public void handle(long now) {

				for (Ant a : antList) {
					gc.setFill(Color.WHITE);
					gc.fillRect(0, 0, width * cellsize, height * cellsize);

					for (int s = 0; s < 200; s++) {
						a.stepForward(a);
					}

					for (int i = 0; i < height; i++) {
						for (int k = 0; k < width; k++) {
							tester.setxPos(k);
							tester.setyPos(i);
							if (tester.checkIfBlack(tester)) {
								gc.setFill(Color.rgb(50, 80, 200));
								gc.fillRect(i * cellsize, k * cellsize, cellsize, cellsize);
							}

						}
					}
				}
			}

		}.start();		
	}

	/*
	 * @Override public void start(Stage primaryStage) {
	 * 
	 * try { root = new GridPane(); Scene scene = new Scene(root, 600, 600);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * ant1.setupBoard(100, 100); new AnimationTimer() {
	 * 
	 * @Override public void handle(long now) { // TODO Auto-generated method stub
	 * for(int i = 0; i < 16; i++) ant1.stepForward(ant1); } }.start(); }
	 */

	public static void main(String[] args) {
		System.out.println("starting");
		launch(args);
		System.out.println("ending");

	}
}
