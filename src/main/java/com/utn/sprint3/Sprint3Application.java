package com.utn.sprint3;

import com.utn.sprint3.Enumeraciones.EstadoPedido;
import com.utn.sprint3.Enumeraciones.FormaPago;
import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.Enumeraciones.TipoEnvio;
import com.utn.sprint3.entidades.*;
import com.utn.sprint3.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class Sprint3Application {
	/*@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(Sprint3Application.class, args);
	}
/*
	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DomicilioRepository domicilioRepository,
						   EmpleadoRepository empleadoRepository, RubroArticuloRepository rubroArticuloRepository,
						   UnidadMedidaRepository unidadMedidaRepository, ArticuloInsumoRepository articuloInsumoRepository,
						   ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository,
						   PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository,
						   FacturaRepository facturaRepository, DetalleFacturaRepository detalleFacturaRepository){
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

			//Creacion de un cliente
			Cliente cliente1 = new Cliente();
			cliente1.setNombre("Juan");
			cliente1.setApellido("Perez");
			cliente1.setTelefono("2615542595");
			cliente1.setEmail("juanperez@gmail.com");
			//cliente1.setFechaAlta(formato.parse("2023-10-26"));
			cliente1.setUsername("juanperez");



			//Creacion de un domicilio
			Domicilio domicilio1 = new Domicilio();
			domicilio1.setCalle("Dorrego");
			domicilio1.setNumero(235);
			domicilio1.setCodigoPostal(5500);
			domicilio1.setLocalidad("Mendoza");
			domicilio1.setNumeroDpto(5);
			domicilio1.setPisoDpto(1);
			//domicilio1.setFechaAlta(formato.parse("2023-09-26"));


			//Agregando un domicilio a cliente
			cliente1.agregarDomicilios(domicilio1);

			//Creacion de un empleado
			Empleado empleado1 = new Empleado();
			empleado1.setNombre("Jorge");
			empleado1.setApellido("Sanchez");
			empleado1.setTelefono("2615543585");
			empleado1.setEmail("jorgesanchez@gmail.com");
			//empleado1.setFechaAlta(formato.parse("2023-10-15"));
			empleado1.setRol(Rol.ADMINISTRADOR);
			empleado1.setUsername("jorgesanchez");

			//Creacion de un Rubro
			RubroArticulo rubro1 = new RubroArticulo();
			rubro1.setDenominacion("bebidas");
			//rubro1.setFechaAlta(formato.parse("2022-04-02"));

			//Creacion de unidad de medida
			UnidadMedida unidadMedida1 = new UnidadMedida();
			unidadMedida1.setAbreviatura("lts");
			unidadMedida1.setDenominacion("litros");
			//unidadMedida1.setFechaAlta(formato.parse("2022-04-02"));

			//Creacion de Articulo Insumo
			ArticuloInsumo articuloInsumo1 = new ArticuloInsumo();
			articuloInsumo1.setStockMinimo(BigDecimal.valueOf(5));
			articuloInsumo1.setStockActual(BigDecimal.valueOf(10));
			articuloInsumo1.setUrlImagen("url");
			articuloInsumo1.setPrecioCompra(BigDecimal.valueOf(20));
			articuloInsumo1.setDenominacion("Coca cola");
			articuloInsumo1.setRubroArticulo(rubro1);
			articuloInsumo1.setUnidadMedida(unidadMedida1);
			//articuloInsumo1.setFechaAlta(formato.parse("2023-10-30"));

			//Creacion de Articulo Manufacturado
			ArticuloManufacturado articuloManufacturado1 = new ArticuloManufacturado();
			articuloManufacturado1.setDenominacion("Hamburguesa BBQ");
			articuloManufacturado1.setDescripcion("Si te gusta la salsa BBQ, la hamburguesa BBQ es la opción perfecta para ti. Se cocina la carne de res a la parrilla y se agrega una salsa BBQ dulce y ahumada encima. Se sirve en un panecillo de brioche tostado con aros de cebolla frita, tocino crujiente y una rebanada de queso cheddar derretido. Esta hamburguesa es una excelente opción para una barbacoa al aire libre con amigos y familiares.");
			articuloManufacturado1.setTiempoEstimadoCocina(30);
			articuloManufacturado1.setPrecioVenta(BigDecimal.valueOf(5000));
			articuloManufacturado1.setCosto(BigDecimal.valueOf(2500));
			articuloManufacturado1.setUrlImagen("/imagen");
			//articuloManufacturado1.setFechaAlta(formato.parse("2023-10-30"));

			//Creacion detalle Articulo Manufacturado
			DetalleArticuloManufacturado detalleArticuloManufacturado1 = new DetalleArticuloManufacturado();
			detalleArticuloManufacturado1.setCantidad(BigDecimal.valueOf(2));
			//detalleArticuloManufacturado1.setFechaAlta(formato.parse("2023-10-30"));

			//Asociando detalle manufacturado con articulo manufacturado
			detalleArticuloManufacturado1.setArticuloManufacturado(articuloManufacturado1);

			//Creacion de un pedido
			Pedido pedido1= new Pedido();
			pedido1.setFechaPedido(formato.parse("2023-10-30"));
			pedido1.setHoraEstimadaFinalizacion(formatoHora.parse("20:30"));
			pedido1.setTotal(BigDecimal.valueOf(11000));
			pedido1.setTotalCosto(BigDecimal.valueOf(5000));
			pedido1.setEstado(EstadoPedido.PAGADO);
			pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido1.setFormaPago(FormaPago.MERCADO_PAGO);
			pedido1.setDomicilioEntrega(domicilio1);
			//pedido1.setFechaAlta(formato.parse("2023-10-30"));

			//Creando detalle de pedido
			DetallePedido detallePedido1 = new DetallePedido();
			detallePedido1.setCantidad(2);
			detallePedido1.setSubtotal(BigDecimal.valueOf(10000));
			detallePedido1.setSubtotalCosto(BigDecimal.valueOf(4500));
			DetallePedido detallePedido2 = new DetallePedido();
			detallePedido2.setCantidad(1);
			detallePedido2.setSubtotal(BigDecimal.valueOf(1000));
			detallePedido2.setSubtotalCosto(BigDecimal.valueOf(500));

			//Asociando detalles de pedido con articulo manufacturado y articulo insumo
			detallePedido1.setArticuloManufacturado(articuloManufacturado1);
			detallePedido2.setArticuloInsumo(articuloInsumo1);

			//Asociando detalles de pedido con pedido
			detallePedido1.setPedido(pedido1);
			detallePedido2.setPedido(pedido1);

			//Agregando un pedido a cliente
			cliente1.agregarPedidos(pedido1);

			//Asignando un pedido a empleado
			empleado1.agregarPedidos(pedido1);

			//Creacion de una factura
			Factura factura1 = new Factura();
			factura1.setFechaFacturacion(formato.parse("2023-10-30"));
			factura1.setMpPaymentId(Long.valueOf(2015789));
			factura1.setMpMerchantOrderId(Long.valueOf(2015789));
			factura1.setMpPreferenceId("2015789");
			factura1.setMpPaymentType("abc");
			factura1.setFormaPago(FormaPago.MERCADO_PAGO);
			factura1.setTotalVenta(BigDecimal.valueOf(10000));
			//factura1.setFechaAlta(formato.parse("2023-10-30"));

			//Creacion de detalle factura
			DetalleFactura detalleFactura1 = new DetalleFactura();
			detalleFactura1.setCantidad(2);
			detalleFactura1.setSubtotal(BigDecimal.valueOf(10000));
			DetalleFactura detalleFactura2 = new DetalleFactura();
			detalleFactura2.setCantidad(1);
			detalleFactura2.setSubtotal(BigDecimal.valueOf(1000));

			//Asignando una factura a su pedido
			factura1.setPedido(pedido1);

			domicilioRepository.save(domicilio1);
			clienteRepository.save(cliente1);
			empleadoRepository.save(empleado1);
			unidadMedidaRepository.save(unidadMedida1);
			rubroArticuloRepository.save(rubro1);
			articuloInsumoRepository.save(articuloInsumo1);
			articuloManufacturadoRepository.save(articuloManufacturado1);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);
			pedidoRepository.save(pedido1);
			detallePedidoRepository.save(detallePedido1);
			detallePedidoRepository.save(detallePedido2);
			facturaRepository.save(factura1);
			detalleFacturaRepository.save(detalleFactura1);
			detalleFacturaRepository.save(detalleFactura2);

			cliente1.mostrarDomicilios();
			cliente1.mostrarPedidos();
		};
	}*/
}
