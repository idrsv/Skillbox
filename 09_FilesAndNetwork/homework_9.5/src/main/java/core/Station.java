package core;

public class Station {
//    private String lineID;
    private String nameStation;

//    public Station(String lineID, String nameStation) {
//        this.lineID = lineID;
//        this.nameStation = nameStation;
//    }

    public Station(String nameStation) {
        this.nameStation = nameStation;
    }
    //    public String getLineID() {
//        return lineID;
//    }
//
//    public void setLineID(String lineID) {
//        this.lineID = lineID;
//    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }
}
