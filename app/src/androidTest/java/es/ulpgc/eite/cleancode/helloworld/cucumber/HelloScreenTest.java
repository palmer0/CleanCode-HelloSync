package es.ulpgc.eite.cleancode.helloworld.cucumber;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloScreenTest {


    public HelloScreenRobot robot = new HelloScreenRobot();

    @Test
    public void testDecirHelloWorldEnPantallaHello() {

        // Given encontrándonos en pantalla "Hello"
        robot.encontrandonosEnPantallaHello();
        // And mostrando mensaje "?"
        robot.mostrandoMensajeVacio();
        // And mostrando botón "Say Hello" activado
        robot.mostrandoBotonSayHelloActivado();
        // And mostrando botón "Go Bye" activado
        robot.mostrandoBotonGoByeActivado();

        // When pulsemos botón "Say Hello"
        robot.pulsemosBotonSayHello();

        // Then mostrando botón "Say Hello" activado
        robot.mostrandoBotonSayHelloActivado();
        // And mostrando botón "Go Bye" activado
        robot.mostrandoBotonGoByeActivado();
        // And mostrando mensaje "Hello World!"
        robot.mostrandoMensajeHelloWorld();
    }
}