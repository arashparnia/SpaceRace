package gameengine.player;

import graphicslib3D.Matrix3D;
import graphicslib3D.Vector3D;
import net.java.games.input.Event;
import sage.input.action.AbstractInputAction;
import sage.physics.IPhysicsObject;
import sage.scene.SceneNode;

/**
 * Created by Javier G on 2/24/2015.
 */
public class MoveYAxis extends AbstractInputAction {
    private float speed = 0.05f;
    private SceneNode avatar;
    private IPhysicsObject playerAvatarP;
    public MoveYAxis(SceneNode c, IPhysicsObject playerAvatarP)
    {
        avatar = c;
        this.playerAvatarP = playerAvatarP;
    }

    @Override
    public void performAction(float time, Event e) {

        if (e.getValue() < -0.4)
        {
            Matrix3D rot = avatar.getLocalRotation();
            Vector3D dir = new Vector3D(0, 0, -1);
            dir = dir.mult(rot);
            dir.scale((double) (speed * time));


            float[] f = playerAvatarP.getLinearVelocity();
            f[0] += (float) dir.getX() * 20;
            f[2] += (float) dir.getZ() * 20;
            if (f[0] < 1500)
                if (f[2] < 1500){
                    playerAvatarP.setLinearVelocity(f);
                }
        }
        else if (e.getValue() > 0.4)
        {
            Matrix3D rot = avatar.getLocalRotation();
            Vector3D dir = new Vector3D(0, 0, 1);
            dir = dir.mult(rot);
            dir.scale((double) (speed * time));

            float[] f = playerAvatarP.getLinearVelocity();
            f[0] = 0;
            f[2] = 0;
            if (f[0] < 1500)
                if (f[2] < 1500){
                    playerAvatarP.setLinearVelocity(f);
                }
        }


    }
}
