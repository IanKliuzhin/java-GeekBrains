import java.util.Random;

/**
 * Created by MPotekhina on 21.06.15.
 */
public class Ship {
    int headPosition;
    int tailPosition;

//    public Ship(int position) {
//        this.headPosition = position;
//    }

    public Ship() {
    }

    public void initWithRandomValues(int fieldSize) {

        Random random = new Random();

//        tailPosition = 1 + (int) (Math.random() * 3);
//        headPosition = 1 + (int) (Math.random() * (10 - tailPosition));

        headPosition = random.nextInt(fieldSize);

        switch (fieldSize - headPosition) {
            case 1:
                tailPosition = headPosition;
                break;
            case 2:
                tailPosition = headPosition + 1;
                break;
            case 3:
                tailPosition = headPosition + random.nextInt(1);
                break;
            case 4:
                tailPosition = headPosition + random.nextInt(2);
                break;
            default:
                tailPosition = headPosition + random.nextInt(3);
        }

    }

    public boolean isIntersectsWithSecondShip(Ship ship) {
        if (headPosition > ship.tailPosition + 1) {
            return false;
        } else {

            if (tailPosition + 1 < ship.headPosition) {
                return false;
            } else {

                return true;
            }
        }
    }
}
