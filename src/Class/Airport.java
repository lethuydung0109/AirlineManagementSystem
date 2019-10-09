package Class;

import Interface.IAirport;

public class Airport implements IAirport {
    private String code;

    public  Airport(String code){
        this.code = code;
    }
    @Override
    public String getName() {
        return code;
    }
}
