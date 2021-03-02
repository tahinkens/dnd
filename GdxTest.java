package com.gdx.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import theseus.dnd2.*;

public class GdxTest extends ApplicationAdapter {

    private static final int FRAME_COLS = 3, FRAME_ROWS = 3;
    private GameCharacter player;
    private OrthographicCamera cam;

    //SpriteBatch batch;
    //Texture img, img2;
    float stateTime;
    Animation<TextureRegion> walkAnimation; // Must declare frame type (TextureRegion)
    Texture walkSheet;
    SpriteBatch spriteBatch;

    @Override
    public void create() {
        
        player = new GameCharacter();
        player.setCoordinates(300,200);
        player.setTextureName("spritesheetClothedEdit5Large.png");
        player.setTexture(new Texture(player.getTextureName()));
        /*
        batch = new SpriteBatch();
        img = new Texture("imgsrc/hilt2Ice.png");
        img2 = new Texture("imgsrc/longSwordBlade1.png");
        */
        // Load the sprite sheet as a Texture
        //walkSheet = new Texture("spritesheet.png");
        walkSheet = player.getTexture();

        // Use the split utility method to create a 2D array of TextureRegions. This is 
        // possible because this sprite sheet contains frames of equal size and they are 
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS);

        // Place the regions into a 1D array in the correct order, starting from the top 
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS - 1];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                if(index != FRAME_COLS * FRAME_ROWS - 1)
                walkFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        walkAnimation = new Animation<TextureRegion>(0.15f, walkFrames); //.025f default

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
        
        float w = Gdx.graphics.getWidth();
	float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(30, 30 * (w / h));

	cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
	cam.update();
    }

    @Override
    public void render() {
        
        handleInput();
        //cam.update();
        /*
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 320, 240);
                batch.draw(img2, 339, 259);
		batch.end();
         */
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, player.getCoordinates()[0], player.getCoordinates()[1]); // Draw current frame at (50, 50)
        spriteBatch.end();
    }

//    @Override
//    public void resize(int width, int height) {
//        cam.viewportWidth = 30f;
//        cam.viewportHeight = 30f * height / width;
//        cam.update();
//    }

    public void handleInput() {
        
        if(Gdx.input.isKeyPressed(Input.Keys.P)) cam.zoom += .2;
        if(Gdx.input.isKeyPressed(Input.Keys.O)) cam.zoom -= .2;
        
        //player.move(); //switch this and lower two lines
        if(Gdx.input.isKeyPressed(Input.Keys.A)) player.setCoordinates(player.getCoordinates()[0] -= 60 * Gdx.graphics.getDeltaTime(),player.getCoordinates()[1]);
        if(Gdx.input.isKeyPressed(Input.Keys.D)) player.setCoordinates(player.getCoordinates()[0] += 60 * Gdx.graphics.getDeltaTime(),player.getCoordinates()[1]);
    }

    @Override
    public void dispose() {
        //batch.dispose();
        //img.dispose();
        spriteBatch.dispose();
        walkSheet.dispose();
    }
}
