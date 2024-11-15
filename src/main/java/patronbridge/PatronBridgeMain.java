package patronbridge;

import encriptacion.EncriptarFactory;
import encriptacion.InterfaceEncriptar;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

public class PatronBridgeMain {
    public static void main(String[] args) {
        try {
            InterfaceEncriptar encriptarProceso = EncriptarFactory.createEncriptar();
            InterfaceMensajeEncriptacion puente = new PuenteMensajeEncriptacion(encriptarProceso);

            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String encryptedMessage = puente.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Mensaje Encriptado > " + encryptedMessage + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}