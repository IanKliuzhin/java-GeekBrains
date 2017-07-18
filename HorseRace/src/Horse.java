import java.util.Random;
import java.util.Scanner;

/**
 * Created by Clown on 27.06.2015.
 */
public class Horse {
    String name;
    Boolean isMale;
    int minSpeed;
    int maxSpeed;
    int currentSpeed;
    int coveredDistance;
    float finishTime;
    int place;

    public Horse() {
        this.place = 999;
        this.coveredDistance = 0;
        this.finishTime = Float.MAX_VALUE;
        Random random = new Random();
        switch (random.nextInt(20)) {
            case 0:
                this.name = "Борян";
                this.isMale = true;
                break;
            case 1:
                this.name = "Колян";
                this.isMale = true;
                break;
            case 2:
                this.name = "Толян";
                this.isMale = true;
                break;
            case 3:
                this.name = "Васян";
                this.isMale = true;
                break;
            case 4:
                this.name = "Пахан";
                this.isMale = true;
                break;
            case 5:
                this.name = "Игорян";
                this.isMale = true;
                break;
            case 6:
                this.name = "Степан";
                this.isMale = true;
                break;
            case 7:
                this.name = "Маха";
                this.isMale = false;
                break;
            case 8:
                this.name = "Саха";
                this.isMale = false;
                break;
            case 9:
                this.name = "Натаха";
                this.isMale = false;
                break;
            case 10:
                this.name = "Катюха";
                this.isMale = false;
                break;
            case 11:
                this.name = "Иоанн";
                this.isMale = true;
                break;
            case 12:
                this.name = "Танюха";
                this.isMale = false;
                break;
            case 13:
                this.name = "Настюха";
                this.isMale = false;
                break;
            case 14:
                this.name = "Баклан";
                this.isMale = true;
                break;
            case 15:
                this.name = "Пацан";
                this.isMale = true;
                break;
            case 16:
                this.name = "Антуан";
                this.isMale = false;
                break;
            case 17:
                this.name = "Буцефан";
                this.isMale = true;
                break;
            case 18:
                this.name = "Сивка";
                this.isMale = true;
                break;
            case 19:
                this.name = "Бурка";
                this.isMale = false;
                break;
        }
    }

    public int setCurrentSpeed(int minSpeed, int maxSpeed) {
        Random random = new Random();
        currentSpeed = minSpeed + random.nextInt(maxSpeed - minSpeed);
        return currentSpeed;
    }

    public void setPlaces(Horse[] horses) {
        this.place = 1;
        boolean isMatching;
        int shiftUs = 0;
        do {
            isMatching = false;
            for (Horse horse : horses) {
                if (!this.name.equals(horse.name)) {
                    if (horse.place == this.place) {
                        isMatching = true;
                        if (horse.finishTime > this.finishTime) {
                            for (Horse horseToShiftPlace : horses) {
                                if (!horseToShiftPlace.name.equals(this.name)) {
                                    if (horseToShiftPlace.place >= this.place) {
                                        horseToShiftPlace.place++;
                                    }
                                }
                            }
                            isMatching = false;
                        } else {
                            shiftUs = 1;
                        }
                    }
                }
            }
            this.place += shiftUs;
            shiftUs = 0;
        } while (isMatching);
    }
}