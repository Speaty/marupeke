public class MarukepeTile {
    private boolean editable;
    private char tileState;

    public MarukepeTile(){
        editable = true;
        tileState = '_';
    }
    public MarukepeTile(boolean editable, char tileState){
        this.editable = editable;
        this.tileState = tileState;
    }

    public boolean setEditable(){
        editable = !editable;
        return !editable;
    }

    public void setSolid(){
        if (editable != false){
            tileState = '#';
            editable = false;
        }
    }
    public void setO(){
        if (editable != false){
            tileState = 'O';
        }
    }
    public void setX(){
        if (editable != false){
            tileState = 'X';
        }
    }

    public void setEmpty(){
        if (editable != false){
            tileState = '_';
        }
    }

    public boolean isEditable() {
        return editable;
    }

    public boolean matches(char a){
        if (tileState != a){
            return false;
        }
        return true;
    }

    public boolean isEmpty(){
        if (editable && tileState == '_'){
            return true;
        }
        return false;
    }

    public char getTileState() {
        return tileState;
    }
}
