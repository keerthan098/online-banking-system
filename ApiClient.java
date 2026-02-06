import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ApiClient {

    // ADD USER
    static void addUser(String name, double balance) {
    try {
        URL checkUrl = new URL("http://localhost:3000/users");
        HttpURLConnection checkCon =
                (HttpURLConnection) checkUrl.openConnection();
        checkCon.setRequestMethod("GET");

        BufferedReader br =
                new BufferedReader(new InputStreamReader(checkCon.getInputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("\"name\": \"" + name + "\"")) {
                System.out.println("User already exists. Cannot create duplicate.");
                br.close();
                return;
            }
        }
        br.close();

        URL url = new URL("http://localhost:3000/users");
        HttpURLConnection con =
                (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        String json =
                "{ \"name\": \"" + name + "\", \"balance\": " + balance + " }";

        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        System.out.println("User created successfully.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    // FIND USER BY NAME → returns {id, balance}
    static int[] findUserByName(String name) {
        try {
            URL url = new URL("http://localhost:3000/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br =
                new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            int id = -1;
            double balance = -1;

            while ((line = br.readLine()) != null) {
                if (line.contains("\"name\": \"" + name + "\"")) {

                    line = br.readLine(); // id
                    id = Integer.parseInt(line.replaceAll("\\D+", ""));

                    line = br.readLine(); // balance
                    balance = Double.parseDouble(
                        line.replaceAll("[^0-9.]", "")
                    );
                    break;
                }
            }
            br.close();

            if (id != -1) {
                return new int[]{ id, (int) balance };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // SHOW BALANCE
    static void showBalance(String name) {
        int[] user = findUserByName(name);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println("Balance: " + user[1]);
        }
    }

    // UPDATE BALANCE
    static void updateBalance(String id, double newBalance){
        try {
            URL url = new URL("http://localhost:3000/users/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PATCH");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String json = "{ \"balance\": " + newBalance + " }";

            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            System.out.println("Balance updated. HTTP Status: " + con.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static double getBalanceById(String id) {
        try {
            URL url = new URL("http://localhost:3000/users/" + id);
            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("\"balance\"")) {
                    return Double.parseDouble(
                            line.replaceAll("[^0-9.]", "")
                    );
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
