package DEM;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Matrix3f;
import com.jme3.math.Triangle;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import java.util.Random;

public class JME extends SimpleApplication {

    private Node node;

    public JME() {
        AppSettings settings = new AppSettings(true);

        settings.setWidth(1500);
        settings.setHeight(700);

        this.settings = settings;

        setShowSettings(false);

        super.start();
    }

    @Override
    public void simpleInitApp() {
        node = new Node();

        flyCam.setMoveSpeed(20);
        flyCam.setRotationSpeed(3);

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

        /*
        for (int j = -5; j < 5; j++) {
            for (int k = -5; k < 5; k++) {
                Box box = new Box(2.5f, 2.5f, 2.5f);
                Geometry geometry = new Geometry("test", box);

                Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                material.setColor("Color", ColorRGBA.Red);

                geometry.setMaterial(material);

                int y = j;
                int z = k;

                geometry.setLocalScale(0, y, z);
                geometry.setLocalTranslation(0, 0, 0);

                node.attachChild(geometry);
            }
        }
        */



        /*
        Random random = new Random();

        for (int i = 0; i <= 50; i++) {
            Sphere sphere = new Sphere(32,32, 2f);
            Geometry geometry = new Geometry("testSphere", sphere);

            sphere.setTextureMode(Sphere.TextureMode.Projected);

            Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            material.setColor("Color", ColorRGBA.randomColor());

            geometry.setMaterial(material);

            int x = random.nextInt(200) - 100;
            int y = random.nextInt(200) - 100;
            int z = random.nextInt(200) - 100;
            geometry.setLocalTranslation(x, y, z);

            node.attachChild(geometry);
        }
        */

        rootNode.attachChild(node);
    }

    @Override
    public void simpleUpdate(float tpf) {
        for(Spatial spacial : node.getChildren()) {
            //spacial.rotate(0, 5  * tpf, 0);
        }
    }

}
