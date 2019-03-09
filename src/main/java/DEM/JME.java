package DEM;

import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.ui.Picture;

import java.util.Random;

public class JME extends SimpleApplication {

    private Node node;

    public JME() {
        AppSettings settings = new AppSettings(true);

        settings.setWidth(1500);
        settings.setHeight(700);

        this.settings = settings;

        setShowSettings(false);
        setDisplayFps(true);

        super.start();
    }

    @Override
    public void simpleInitApp() {
        node = new Node();

        flyCam.setMoveSpeed(20);
        flyCam.setRotationSpeed(3);


        setPlanet(new Sphere(32,32, 10f), "sunPlanet", "sun.jpg", -7, -80);
        setPlanet(new Sphere(32,32, 1f), "mercurePlanet", "mercure.jpg", 20, -80);
        setPlanet(new Sphere(32,32, 1.4f), "venusPlanet", "venus.jpg", 30, -80);

        Sphere sphere = new Sphere(32,32, 2f);
        Geometry geometry = new Geometry("earthPlanet", sphere);

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");

        Texture texture = assetManager.loadTexture("earth.jpg");
        material.setTexture("ColorMap", texture);

        geometry.setMaterial(material);

        int x = 44;
        int y = 0;
        int z = 0;
        geometry.setLocalTranslation(x, y, z);

        Quaternion quat = new Quaternion();
        quat.fromAngles(-24,-24, FastMath.PI);

        geometry.setLocalRotation(quat);

        node.attachChild(geometry);

        setPlanet(new Sphere(32,32, 0.8f), "marsPlanet", "mars.jpg", 56, -80);
        setPlanet(new Sphere(32,32, 5.5f), "jupiterPlanet", "jupiter.jpg", 74, -80);

        Sphere sphere1 = new Sphere(32,32, 4f);
        Geometry geometry1 = new Geometry("saturnPlanet", sphere1);

        Material material1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");

        Texture texture1 = assetManager.loadTexture("saturn.jpg");
        material1.setTexture("ColorMap", texture1);

        geometry1.setMaterial(material1);

        int x1 = 95;
        int y1 = 0;
        int z1 = 0;
        geometry1.setLocalTranslation(x1, y1, z1);

        Quaternion quat1 = new Quaternion();
        quat1.fromAngles(62,-62, FastMath.PI);

        geometry1.setLocalRotation(quat1);

        node.attachChild(geometry1);

        setPlanet(new Sphere(32,32, 2f), "uranusPlanet", "uranus.jpg", 108, -80);
        setPlanet(new Sphere(32,32, 2.3f), "neptunePlanet", "neptune.jpg", 119, -80);

        /*
        for (int j = -5; j < 5; j++) {
            for (int k = -5; k < 5; k++) {
                Box box = new Box(2.5f, 2.5f, 2.5f);
                Geometry geometry = new Geometry("test", box);

                Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                material.setColor("Color", ColorRGBA.Blue);

                geometry.setMaterial(material);

                int x = j;
                int z = k;

                geometry.setLocalScale(x, 0, z);
                geometry.setLocalTranslation(0, 0, 0);

                node.attachChild(geometry);
            }
        }

        for (int j = -5; j < 5; j++) {
            for (int k = -5; k < 5; k++) {
                Box box = new Box(2.5f, 2.5f, 2.5f);
                Geometry geometry = new Geometry("test", box);

                Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                material.setColor("Color", ColorRGBA.Green);

                geometry.setMaterial(material);

                int z = j;
                int y = k;

                geometry.setLocalScale(0, y, z);
                geometry.setLocalTranslation(0, 0, 0);

                node.attachChild(geometry);
            }
        }
        */

        rootNode.attachChild(node);
    }

    @Override
    public void simpleUpdate(float tpf) {
        for(Spatial spacial : node.getChildren()) {
            spacial.rotate(0, 0, 2  * tpf);
        }
    }

    private void setPlanet(Sphere sphere, String nameSphere, String resource, int positionX, int angle) {
        Geometry geometry = new Geometry(nameSphere, sphere);

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");

        Texture texture = assetManager.loadTexture(resource);
        material.setTexture("ColorMap", texture);

        geometry.setMaterial(material);

        int x = positionX;
        int y = 0;
        int z = 0;
        geometry.setLocalTranslation(x, y, z);

        Quaternion quat = new Quaternion();
        quat.fromAngles(angle,0, FastMath.PI);

        geometry.setLocalRotation(quat);

        node.attachChild(geometry);
    }

}
