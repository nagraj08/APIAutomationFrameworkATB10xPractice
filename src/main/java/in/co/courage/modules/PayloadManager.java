package in.co.courage.modules;
import com.google.gson.Gson;
import in.co.courage.pojos.*;
public class PayloadManager {

    // Convert Java Objects to JSON
    // Gson -> Ser and DeSer.
    Gson gson;

    public String createPayloadBookingAsString(){
        User user  = new User();
        user.setName("Nagraj");
        user.setJob("Software Engineer");

        System.out.println(user);

        // Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringUser = gson.toJson(user);
        System.out.println(jsonStringUser);
        return jsonStringUser;
    }

    // Converting the String to the JAVA Object
    public UserResponse userResponse(String responseString) {
        gson = new Gson();
        UserResponse userResponse = gson.fromJson(responseString, UserResponse.class);
        return userResponse;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setEmail("eve.holt@reqres.in");
        auth.setPassword("cityslicka");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    // JSON to Java
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1  = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken().toString();

    }

    public User getResponseFromJSON(String getResponse){
        gson = new Gson();
        User user = gson.fromJson(getResponse,User.class);
        return user;
    }

    public String fullUpdatePayloadAsString() {
        User user = new User();
        user.setName("Nagraj");
        user.setJob("Student");
        return gson.toJson(user);


    }










}
