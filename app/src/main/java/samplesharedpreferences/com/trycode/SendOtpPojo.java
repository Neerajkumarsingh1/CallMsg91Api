package samplesharedpreferences.com.trycode;

/**
 * Created by neeraj on 9/2/18.
 */

public class SendOtpPojo {
  private   String sender;
   private String route;
    private String mobile;
   private String authkey;
    private Number country;
     private String message;





    public String getSender() {
        return sender;
    }

    public String getRoute() {
        return route;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAuthkey() {
        return authkey;
    }

    public Number getCountry() {
        return country;
    }

    public String getMessage() {
        return message;
    }
}
