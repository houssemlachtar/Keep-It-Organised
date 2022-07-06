package core.enums;


public enum PopupType {
    EDIT("Edit"),
    ADD("Add");

    public final String VALUE;
    PopupType(String value){
        VALUE = value;
    }

    @Override
    public String toString() {
        return VALUE;
    }
}
