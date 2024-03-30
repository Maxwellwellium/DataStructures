import java.util.Objects;

enum BloodType {
    APOS, BPOS, OPOS, ABPOS,
    ANEG, BNEG, ONEG, ABNEG;
}
public class BloodData {

    BloodType bd;

    public BloodData() {
        this.bd = BloodType.ONEG;
    }
    public void UpdateBloodData(boolean rh) {
        if (rh) {
            this.bd = switch (bd) {
                case ANEG, APOS -> BloodType.APOS;
                case BNEG, BPOS -> BloodType.BPOS;
                case ABNEG, ABPOS -> BloodType.ABPOS;
                case ONEG, OPOS -> BloodType.OPOS;
                default -> BloodType.OPOS;
            };
        }else{
            this.bd = switch (bd) {
                case ANEG, APOS -> BloodType.ANEG;
                case BNEG, BPOS -> BloodType.BNEG;
                case ABNEG, ABPOS -> BloodType.ABNEG;
                case ONEG, OPOS -> BloodType.ONEG;
                default -> BloodType.ONEG;
            };
        }
        printBlood();
    }

    public void UpdateBloodData(String type) {
        switch (type) {
            case "A": this.bd = switch (this.bd) {
                case APOS, BPOS, ABPOS, OPOS -> BloodType.APOS;
                case ANEG, BNEG, ABNEG, ONEG -> BloodType.ANEG;
            };
                break;
            case "B": this.bd = switch (this.bd) {
                case APOS, BPOS, ABPOS, OPOS -> BloodType.BPOS;
                case ANEG, BNEG, ABNEG, ONEG -> BloodType.BNEG;
            };
                break;
            case "AB": this.bd = switch (this.bd) {
                case APOS, BPOS, ABPOS, OPOS -> BloodType.ABPOS;
                case ANEG, BNEG, ABNEG, ONEG -> BloodType.ABNEG;
            };
                break;
            case "O": this.bd = switch (this.bd) {
                case APOS, BPOS, ABPOS, OPOS -> BloodType.OPOS;
                case ANEG, BNEG, ABNEG, ONEG -> BloodType.ONEG;
            };
                break;
        }
        printBlood();
    }

    public String printBlood() {
        String blood = switch(this.bd) {
            case APOS -> "Bloodtype: A Positive";
            case ANEG -> "Bloodtype: A Negative";
            case BPOS -> "Bloodtype: B Positive";
            case BNEG -> "Bloodtype: B Negative";
            case ABPOS -> "Bloodtype: AB Positive";
            case ABNEG -> "Bloodtype: AB Negative";
            case OPOS -> "Bloodtype: O Positive";
            case ONEG -> "Bloodtype: O Negative";
        };
        System.out.println(blood);
        return blood;
    }
    public BloodType getBd() {
        return bd;
    }
    public void setBd(BloodType bd) {
        this.bd = bd;
    }
}


