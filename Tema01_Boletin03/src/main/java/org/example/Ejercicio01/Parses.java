package org.example.Ejercicio01;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.example.Ejercicio03.Libro;
import org.example.Ejercicio04.Cliente;
import org.example.Ejercicio04.Producto;
import org.example.Ejercicio04.Pedido;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase para  parsear ficheros XML.
 */
public class Parses {
    /**
     * Parsea el fichero XML de empleados y devuelve un array de objetos Empleado.
     *
     * @return Lista de objetos Empleado.
     * @throws IOException                  Fallo al leer el fichero.
     * @throws ParserConfigurationException Fallo en la configuración del parser XML.
     * @throws SAXException                 Fallo al parsear el fichero XML.
     */
    public static Empleado[] parseEmpleados() throws IOException, ParserConfigurationException, SAXException {
        Empleado[] empleados = null;
        try (InputStream is = Parses.class.getResourceAsStream("/Datasets/empleados.xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(is);
            dom.getDocumentElement().normalize();
            NodeList items = dom.getElementsByTagName("empleado");

            empleados = new Empleado[items.getLength()];

            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                Element elem = (Element) item;

                String idEmpleado = item.getAttributes().getNamedItem("id").getNodeValue();

                NodeList nombreNodes = elem.getElementsByTagName("nombre");
                Node nombreNode = nombreNodes.item(0);
                String nombreEmpleado = nombreNode.getTextContent();

                NodeList salrioNodes = elem.getElementsByTagName("salario");
                Node salarioNode = salrioNodes.item(0);
                Double salarioEmpleado = Double.parseDouble(salarioNode.getTextContent());

                empleados[i] = new Empleado(idEmpleado, nombreEmpleado, salarioEmpleado);
            }

        }
        return empleados;
    }

    /**
     * Parsea el fichero XML de empleados y devuelve un array de objetos Empleado.
     *
     * @return Lista de objetos Empleado.
     * @throws IOException                  Fallo al leer el fichero.
     * @throws ParserConfigurationException Fallo en la configuración del parser XML.
     * @throws SAXException                 Fallo al parsear el fichero XML.
     */
    public static Empleado[] parseEmpleadosActividad2() throws IOException, ParserConfigurationException, SAXException {
        Empleado[] empleados = null;
        try (InputStream is = Parses.class.getResourceAsStream("/Datasets/empleados.xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(is);
            dom.getDocumentElement().normalize();
            NodeList items = dom.getElementsByTagName("empleado");

            empleados = new Empleado[items.getLength()];

            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                Element elem = (Element) item;

                String idEmpleado = item.getAttributes().getNamedItem("id").getNodeValue();

                NodeList nombreNodes = elem.getElementsByTagName("nombre");
                Node nombreNode = nombreNodes.item(0);
                String nombreEmpleado = nombreNode.getTextContent();

                NodeList salarioNodes = elem.getElementsByTagName("salario");
                Node salarioNode = salarioNodes.item(0);
                Double salarioEmpleado = Double.parseDouble(salarioNode.getTextContent());

                NodeList departamentoNodes = elem.getElementsByTagName("departamento");
                Node departamentoNode = departamentoNodes.item(0);
                String departamentoEmpleado = departamentoNode.getTextContent();

                NodeList fechaNodes = elem.getElementsByTagName("fechaAlta");
                Node fechaNode = fechaNodes.item(0);
                String fechaAlta = fechaNode.getTextContent();

                empleados[i] = new Empleado(idEmpleado, nombreEmpleado, salarioEmpleado, departamentoEmpleado, fechaAlta);
            }

        }
        return empleados;
    }

    /**
     * Parsea el fichero XML de libros y devuelve un array de objetos Libro.
     *
     * @return Lista de objetos Libro.
     * @throws IOException                  Fallo al leer el fichero.
     * @throws ParserConfigurationException Fallo en la configuración del parser XML.
     * @throws SAXException                 Fallo al parsear el fichero XML.
     */
    public static Libro[] parseBiblioteca() throws IOException, ParserConfigurationException, SAXException {
        Libro[] libros = null;
        try (InputStream is = Parses.class.getResourceAsStream("/Datasets/biblioteca.xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(is);
            dom.getDocumentElement().normalize();
            NodeList items = dom.getElementsByTagName("libro");

            libros = new Libro[items.getLength()];
            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                Element elem = (Element) item;

                //String idEmpleado = item.getAttributes().getNamedItem("id").getNodeValue();

                NodeList tituloNodes = elem.getElementsByTagName("titulo");
                Node tituloNode = tituloNodes.item(0);
                String tituloLibro = tituloNode.getTextContent();

                NodeList generosNodes = elem.getElementsByTagName("generos");
                List<String> listaGeneros = new ArrayList<>();
                for (int j = 0; j < generosNodes.getLength(); j++) {
                    Node itemGenero = generosNodes.item(j);
                    Element elemGenero = (Element) itemGenero;

                    NodeList generoNodes = elemGenero.getElementsByTagName("genero");
                    for (int k = 0; k < generoNodes.getLength(); k++) {
                        Node generoNode = generoNodes.item(k);
                        String generoLibro = generoNode.getTextContent();
                        listaGeneros.add(generoLibro);
                    }
                }
                libros[i] = new Libro(tituloLibro, listaGeneros);
            }

        }
        return libros;
    }

    /**
     * Parsea el fichero XML de pedidos y devuelve un array de objetos Pedido.
     * @return Lista de objetos Pedido.
     * @throws IOException Fallo al leer el fichero.
     * @throws ParserConfigurationException Fallo en la configuración del parser XML.
     * @throws SAXException Fallo al parsear el fichero XML.
     */
    public static Pedido[] parsePedidos() throws IOException, ParserConfigurationException, SAXException {
        Pedido[] pedidos = null;
        try (InputStream is = Parses.class.getResourceAsStream("/Datasets/pedidos.xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(is);
            dom.getDocumentElement().normalize();
            NodeList nodeList = dom.getElementsByTagName("pedido");

            pedidos = new Pedido[nodeList.getLength()];

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node item = nodeList.item(i);
                Element elem = (Element) item;

                // ID Pedido
                String idPedido = item.getAttributes().getNamedItem("id").getNodeValue();
                // Objeto Cliente: nombre y email.
                NodeList clienteNodes = elem.getElementsByTagName("cliente");
                Element clienteNode = (Element) clienteNodes.item(0);

                String nombreCliente = clienteNode.getElementsByTagName("nombre").item(0).getTextContent();
                String emailCliente = clienteNode.getElementsByTagName("email").item(0).getTextContent();

                Cliente cliente = new Cliente(nombreCliente, emailCliente);

                // Fecha
                NodeList fechaNodes = elem.getElementsByTagName("fecha");
                Node fechaNode = fechaNodes.item(0);
                String fecha = fechaNode.getTextContent();

                // Items
                NodeList productosNodes = elem.getElementsByTagName("item");
                Producto[] productos = new Producto[productosNodes.getLength()];
                // Entramos en Items
                for (int p = 0; p < productosNodes.getLength(); p++) {
                    Node productoItem = productosNodes.item(p);
                    Element productoElement = (Element) productoItem;
                    // Atributo sku
                    String sku = productoElement.getAttributes().getNamedItem("sku").getNodeValue();
                    // Elemento descripcion
                    NodeList descripcionNodes = productoElement.getElementsByTagName("descripcion");
                    Node descripcionNode = descripcionNodes.item(0);
                    String descripcion = descripcionNode.getTextContent();
                    // Elemento Cantidad
                    NodeList cantidadNodes = productoElement.getElementsByTagName("cantidad");
                    Node cantidadNode = cantidadNodes.item(0);
                    float cantidad = Float.parseFloat(cantidadNode.getTextContent());
                    // Elemento precioUnitario
                    NodeList precioNodes = productoElement.getElementsByTagName("precioUnitario");
                    Node precioNode = precioNodes.item(0);
                    float precioUnitario = Float.parseFloat(precioNode.getTextContent());

                    Producto producto = new Producto(sku, descripcion, cantidad, precioUnitario);
                    productos[p]= producto;
                }

                // Total
                NodeList totalNodes = elem.getElementsByTagName("total");
                Node totalNode = totalNodes.item(0);
                float total = Float.parseFloat(totalNode.getTextContent());
                pedidos[i] = new Pedido(idPedido, cliente, fecha, productos, total);
            }
        }
        return pedidos;
    }

}
