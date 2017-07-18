/**
 * Created by Clown on 12.07.2015.
 */
public class Ship {
    static final int SURROUNDING_AREA_THICKNESS = 1;
    boolean isHorizontal;
    int decksAmount;
    int headColumn;
    int headRow;
    int surroundingAreaFirstRow;
    int surroundingAreaFirstColumn;
    int surroundingAreaLastRow;
    int surroundingAreaLastColumn;
    int lives;

    Ship(int decksAmount, boolean isHorizontal) {
        this.decksAmount = decksAmount;
        this.lives = decksAmount;
        this.isHorizontal = isHorizontal;
    }

    void initSurroundingArea() {
        this.surroundingAreaFirstColumn = this.headColumn - SURROUNDING_AREA_THICKNESS;
        this.surroundingAreaFirstRow = this.headRow - SURROUNDING_AREA_THICKNESS;
        if (this.isHorizontal) {
            this.surroundingAreaLastColumn = this.surroundingAreaFirstColumn - 1 + this.decksAmount + 2 * SURROUNDING_AREA_THICKNESS;
            this.surroundingAreaLastRow = this.headRow + SURROUNDING_AREA_THICKNESS;
        } else {
            this.surroundingAreaLastColumn = this.headColumn + SURROUNDING_AREA_THICKNESS;
            this.surroundingAreaLastRow = this.surroundingAreaFirstRow - 1 + this.decksAmount + 2 * SURROUNDING_AREA_THICKNESS;
        }
        if (this.surroundingAreaFirstRow < 0) {
            this.surroundingAreaFirstRow = 0;
        }
        if (this.surroundingAreaFirstColumn < 0) {
            this.surroundingAreaFirstColumn = 0;
        }
        if (this.surroundingAreaLastRow >= Field.ROWS_AMOUNT) {
            this.surroundingAreaLastRow = Field.ROWS_AMOUNT - 1;
        }
        if (this.surroundingAreaLastColumn >= Field.COLUMNS_AMOUNT) {
            this.surroundingAreaLastColumn = Field.COLUMNS_AMOUNT - 1;
        }
    }
}


