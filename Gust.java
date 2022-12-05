package ufjf;
import robocode.*;
import java.awt.Color;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class Gust extends Robot {
    public void run(){
        do {
            turnRadarLeft(360);
            turnRight(300);
            }   while(true);
        }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        if(e.getDistance() < 250) {
		    fire(3);
        }
        double distancia = e.getDistance();
        double angulo = e.getBearing();
        turnRight(angulo);
        ahead(distancia/2);
	}

	public void onHitByBullet(HitByBulletEvent e) {
        turnRight(e.getBearing());
		ahead(50);
	}

    public void onBulletHit(BulletHitEvent e) {
    //     Acertos++;
    }

    public void onBulletMissed(BulletMissedEvent e) {
    //     vacilos++;
    }

	public void onHitWall(HitWallEvent e) {
		turnLeft(180);
	}	

    public void onHitRobot(HitRobotEvent e) {
        fire(2);
    }

    public void dancinha() {
        ahead(5);
        turnRight(360D);
        turnGunLeft(360D);
        turnRadarRight(30D);
}

    public void onWIn(WinEvent e) {
        dancinha();
    }

    public void onDeath(DeathEvent e) {
        System.out.println(getName()+"morreu!");
        System.out.println("Quantidade de inimigos ainda vivos: "+getOthers());
    }
}