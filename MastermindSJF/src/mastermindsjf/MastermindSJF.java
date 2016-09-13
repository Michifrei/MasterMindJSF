
package mastermindsjf;

import org.json.*;



public class MastermindSJF
{
    public static void main(String[] args) 
    {
        
        String[] testStringArray = 
        {
            "2|{\"Answer\":[0,1,1,1,2,2]}",
            "3|{\"Won\":true,\"Tries\":1,\"Code\":[0,1,2]}",
            "5|{\"Accept\":true,\"Attributes\":{\"NbrColors\":6,\"MaxTries\":122,\"CodeLength\":4}}",
            "6|{\"Message\":\"I have no idea that happened\",\"ErrorType\":3}"
        };
        
        String uriString = "ws://86.119.39.157:8080/echo";
    
        //MastermindClient(new URI(uriString), new Draft_10());
        
        
        
        //Start
        
        // connect to server
      
        
        // create new game
        
        // recieve accept or recieve error
        
        // make a guess
        
        // recieve answer error or game end
        
            // if answer proceed:
            
            // if game end proceed here:
            
            // if error stop
            
        
        testStringInterpreter(testStringArray[2]);
    }
    
    static void testStringInterpreter(String serverMessageString)
    {   
        String[] parts = serverMessageString.split("[|]");
        int typeNumber = Integer.parseInt(parts[0]);
        String messageString = parts[1];
        JSONObject jsonObject = new JSONObject(messageString);
        
        switch (typeNumber)
        {
            case 2: 
                recievedAnswer(jsonObject);
                break;
            case 3:
                gameEnd(jsonObject);
                break;
            case 5:
                acceptResponse(jsonObject);
                break;
            case 6:
                errorMsg(jsonObject);
                break;
            default:
                System.out.println("Error: Wrong typeNumber"); 
                break;
        }
    }

    private static void recievedAnswer(JSONObject jsonObject) 
    {
        int[] answer = getArrayFromJSONObject(jsonObject, "Answer");
        
        
    }

    private static void gameEnd(JSONObject jsonObject) 
    {
        boolean gameWon = jsonObject.getBoolean("Won");
        int tries = jsonObject.getInt("Tries");
        int[] code = getArrayFromJSONObject(jsonObject, "Code"); 
        
        
    }

    private static void acceptResponse(JSONObject jsonObject) 
    {
        boolean accepted = jsonObject.getBoolean("Accept");
        JSONObject attributes = jsonObject.getJSONObject("Attributes");
        int numberOfColors = attributes.getInt("NbrColors");
        int maxTries = attributes.getInt("MaxTries");
        int codeLength = attributes.getInt("CodeLength");
        
        System.out.println("Accept: "+accepted);
        System.out.println("NbrColors: "+numberOfColors);
        System.out.println("MaxTries: "+maxTries);
        System.out.println("codeLength: "+codeLength);
    }

    private static void errorMsg(JSONObject jsonObject) 
    {
           String errorMsg = jsonObject.getString("Message");
           System.out.println("ERROR: "+errorMsg);
    }
    
    
    // Utility
    private static int[] getArrayFromJSONObject(JSONObject jsonObject, String key)
    {
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        int[] answerArray = new int[jsonArray.length()];
        
        // Fill answerArray with the JSON values
        for(int i=0; i<jsonArray.length(); i++)
        {
            answerArray[i] = jsonArray.getInt(i);
            //System.out.println("answerArray["+i+"] = "+answerArray[i]);
        }
        return answerArray;
    }
}

