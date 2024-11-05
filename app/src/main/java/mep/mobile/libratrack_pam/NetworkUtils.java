package mep.mobile.libratrack_pam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    public static String getHttpResponse(String urlString) {
        String result = "";
        HttpURLConnection urlConnection = null;

        try {
            // 1. Membuat URL
            URL url = new URL(urlString);

            // 2. Membuka koneksi
            urlConnection = (HttpURLConnection) url.openConnection();

            // 3. Menentukan Metode Permintaan (GET atau POST)
            urlConnection.setRequestMethod("GET");

            // 4. Membaca Response Code
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 berarti sukses
                // 5. Membaca Respons
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                // Menutup stream
                in.close();

                // 6. Menyimpan hasil ke variabel result
                result = response.toString();
            } else {
                System.out.println("GET request failed, response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Menutup koneksi
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }
}
