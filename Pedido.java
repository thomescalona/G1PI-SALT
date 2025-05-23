//David Monzón Sánchez
package POJOS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private int numero;
    private LocalDate fecha;
    private String dirEnvio;
    private Cliente cliente;
    private String estado;
    private MetodoPago metodoPago;
    private ArrayList<LineaPedido> lineasPedido = new ArrayList<>();


    public Pedido(int numero, LocalDate fecha, Cliente cliente,
                  String estado, MetodoPago mp) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.metodoPago = mp;
    }
    // constructor con lo basico
    public Pedido(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
    }
    // constructor del array

    public Pedido(ArrayList items) {
        this.lineasPedido = items;
    }

    // constructor vacio
    public Pedido() {
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public void setDirEnvio(String dirEnvio) {
        this.dirEnvio = dirEnvio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float calcularTotal() {
        float total = 0;
        for (LineaPedido item : lineasPedido) {
            total += item.getSubtotal();
        }
        return total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    // gestión de lineas de depido
    // Añadir Linea Pedido a la lista
    public boolean anadirLineaPedido(LineaPedido lineaPedido) {
        boolean insertado = false;
        if (lineaPedido != null) {
            insertado = lineasPedido.add(lineaPedido);
        }
        return insertado;
    }

    // Buscar Linea de Pedido en la lista
    public LineaPedido buscaLineaPedido(int cantidad, Articulo articulo) {
        LineaPedido lineaPedido = null, enc = null;
        boolean encontrado = false;
        Iterator iterator = lineasPedido.iterator();
        while (iterator.hasNext() && encontrado == false) {
            lineaPedido = (LineaPedido) iterator.next();
            if (lineaPedido.getCantidad() == cantidad && lineaPedido.getArticulo() == articulo) {
                enc = lineaPedido;
                encontrado = true;
            }
        }
        return enc;
    }

    // Borrar Linea de Pedido de la lista
    public boolean borrarLineaPedido(LineaPedido lineaPedido) {
        boolean insertado = false;
        if (lineaPedido != null) {
            insertado = lineasPedido.remove(lineaPedido);
        }
        return insertado;
    }

    // borrar linea de la lista
    // a partir de su posición
    public boolean borrarLinea(int i) {
        boolean insertado = false;
        LineaPedido l;
        if (i >= 0 && i < lineasPedido.size() && lineasPedido.get(i) != null) {
            l = lineasPedido.get(i);
            insertado = lineasPedido.remove(l);
        }
        return insertado;
    }

    // Modifica linea de la lista
    // a partir de su posición
    public boolean modifLinea(int i, LineaPedido lineaPedido) {
        boolean insertado = false;
        LineaPedido l;
        if (i >= 0 && i < lineasPedido.size() && lineasPedido.get(i) != null) {
            l = lineasPedido.get(i);
            l.setCantidad(lineaPedido.getCantidad());
            l.setArticulo(lineaPedido.getArticulo());
            insertado = true;
        }
        return insertado;
    }

    // mostrar todos los artículos de la lista
    public void mostrarPedido() {
        System.out.println("Listado del pedido.");
        System.out.println("Cliente :" + cliente.info());
        System.out.println("Número pedido :" + getNumero());
        System.out.println("Fecha :" + getFecha());
        System.out.println("Lineas del pedido:");
        for (LineaPedido l : lineasPedido) {
            System.out.println(l.toString());
            System.out.println("");
        }
        System.out.println();
    }

    // devuelve la cantidad de lineas en la lista
    public int numLineas() {
        int num = 0;
        num = lineasPedido.size();
        return num;
    }

    // Comprobar si la lista está vacía
    public boolean vaciaLista() {
        boolean vacia = false;
        if (lineasPedido.isEmpty()) {
            vacia = true;
        }
        return vacia;
    }

    // Vaciar la lista
    public boolean vaciarLista() {
        boolean vacia = false;
        if (lineasPedido != null) {
            vacia = true;
            lineasPedido.clear();
        }
        return vacia;
    }

    // devuelve la linea de la posición i
    // null si no es posible
    public LineaPedido getLinea(int i) {
        LineaPedido a = null;
        if (i >= 0 && i <= numLineas() - 1) {
            a = lineasPedido.get(i);
        }
        return a;
    }

}
