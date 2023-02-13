package org.wgomez.recursividad.ejemplo;

import org.wgomez.recursividad.ejemplo.modelos.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {

public static void main (String[] args) {

    Componente pc = new Componente("Gabinete PC ATX");
    Componente poder = new Componente("Fuente Poder 700w");
    Componente placaMadre = new Componente("MainBoard Asus sockets AMD");
    Componente cpu = new Componente("Cpu AMD Ryzen 5 2800");
    Componente teclado = new Componente("Teclado");
    Componente raton = new Componente("Mouse");
    Componente ventilador = new Componente("Ventilador CPU");
    Componente disipador = new Componente("Disipador");
    Componente targetaVideo = new Componente("Nvidia RTX 3080 8GB");
    Componente gpu = new Componente("Nvidia GPU RTX");
    Componente gpuRam = new Componente("4GB Ram");
    Componente gpuRam2 = new Componente("4GB Ram");
    Componente gpuventiladores = new Componente("ventiladores");
    Componente ram = new Componente("Memoria Ram 32GB");
    Componente ssd = new Componente("Disco SSD 2T");

    cpu.addComponente(ventilador).addComponente(disipador);

    targetaVideo.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuventiladores);

    placaMadre.addComponente(cpu).addComponente(targetaVideo).addComponente(ram).addComponente(ssd);

    pc.addComponente(poder).addComponente(placaMadre).addComponente(teclado).addComponente(raton);

    metodoRecursivo(pc, 0).forEach(
            c -> System.out.println("\t-".repeat(c.getNivel()) + c.getNombre()));


}

public static Stream<Componente> metodoRecursivo (Componente c, int nivel) {

    c.setNivel(nivel);
    return Stream.concat(Stream.of(c),
            c.getHijos().stream().flatMap(hijo -> metodoRecursivo(hijo, nivel + 1)));

}

/*public static void metodoRecursivo (Componente c, int nivel) {


    System.out.println("\t-".repeat(nivel) + c.getNombre());
    if (c.tieneHijos()) {
        for (Componente component : c.getHijos()) {

            metodoRecursivo(component, nivel + 1);
        }
    }*/

}


