package page;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeeJson {

    public LeeJson(){

    }

    public List recuperarJson() throws IOException {
        String url = "https://farmanet.minsal.cl/index.php/ws/getLocalesTurnos";
        InputStream is = new URL(url).openStream();
        Gson gson = new Gson();
        String fichero = "";
        List<Farmacia> farmacias = null;
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")))){
            String lineas;
            while((lineas = rd.readLine()) != null){
                fichero = fichero + lineas;
            }
            Type listadoFarmacias = new TypeToken<List<Farmacia>>(){}.getType();
            farmacias = gson.fromJson(fichero, listadoFarmacias);
            System.out.println("resuelto");
        } catch (IOException e){
            e.printStackTrace();
        }
        return farmacias;
    }

    public void generarReporte() throws IOException {
        List<Farmacia> farmacias = recuperarJson();
        String urlMaps = "https://www.google.cl/maps/@";
        String url;
        for (Farmacia f : farmacias){
            url = urlMaps + f.getLocal_lat() + "," + f.getLocal_lng() + "17z";
            DriverContext.getDriver().get(url);
            DriverContext.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            PdfQaNovaReports.addWebReportImage("Farmacia " + f.getLocal_nombre() + " de " + f.getComuna_nombre(), f.getLocal_nombre() + " ubicacion en la comuna de " + f.getComuna_nombre(), EstadoPrueba.DONE, false);
        }
    }
}
