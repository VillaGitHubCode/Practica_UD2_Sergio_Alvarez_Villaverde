package com.utad.practica_ud2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.practica_ud2.databinding.FragmentGeneralNewsBinding

class GeneralNewsFragment : Fragment() {

    private lateinit var _binding : FragmentGeneralNewsBinding
    private val binding : FragmentGeneralNewsBinding get() = _binding

    private var generalNewsList : MutableList<New> = mutableListOf()
    private lateinit var sportNewList: List<New>
    private lateinit var techNewList: List<New>
    private lateinit var adapter: NewListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGeneralNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generalNewsList.addAll(getGeneralNewsList())
        binding.rvGeneralNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = NewListAdapter(requireContext()) {new -> navigateToDetailActivity(new)}

        binding.rvGeneralNews.adapter = adapter
        adapter.submitList(generalNewsList)

        sportNewList = SportNewsFragment.getSportsNewsList()
        techNewList = TechNewsFragment.getTechNewsList()

        binding.fabeAddNews.setOnClickListener { updateList() }
    }

    private fun mixLists(sportNewList: List<New>, techNewList: List<New>): MutableList<New>? {
        val mixedList = mutableListOf<New>()
        mixedList.addAll(getGeneralNewsList())
        mixedList.addAll(sportNewList)
        mixedList.addAll(techNewList)
        mixedList.shuffle()
        return mixedList


        return mixedList

    }

    private fun updateList() {
        val updatedList = mixLists(sportNewList, techNewList)
        adapter.submitList(updatedList)
    }

    private fun navigateToDetailActivity(selectedNew: New) {

        val direction = GeneralNewsFragmentDirections.actionGeneralNewsFragmentToDetailNewActivity(selectedNew)
        findNavController().navigate(direction)
    }

    private fun getGeneralNewsList(): List<New> {
        return listOf(
            New(
                title = "Por qué aumenta el cáncer entre adultos jóvenes: los tumores en menores de 50 años crecen casi un 80% en tres décadas",
                image = "https://imagenes.elpais.com/resizer/k3917Z7Bpbho8_pmQZlMgrwI_yw=/1200x0/filters:focal(2993x618:3003x628)/cloudfront-eu-central-1.images.arcpublishing.com/prisa/FVKRFXAKYFDCVKM3NFAI2ZEQ3A.jpg",
                description = "Hay muchos motivos por los que una célula humana puede enloquecer y empezar a multiplicarse descontroladamente hasta generar un tumor maligno. Fumar, por ejemplo, provoca mutaciones que pueden llevar a la célula a reproducirse sin freno. También el alcohol, la exposición excesiva al sol o, simplemente, el azar, pueden favorecer esos errores en la replicación celular. La edad ha sido siempre, sin embargo, la variable de más peso: a más años, más riesgo de que se produzcan esas erratas porque las células se degradan, los mecanismos de control se van perdiendo y el sistema de defensa se deteriora. Sin embargo, desde hace un tiempo, algo está cambiando en la expansión tradicional de la enfermedad: la edad sigue siendo un factor determinante, pero cada vez hay más casos entre adultos jóvenes y las causas no están claras.\n" +
                        "\n" +
                        "Un estudio publicado recientemente en la revista BMJ Oncology calcula que la incidencia mundial de tumores entre menores de 50 años ha aumentado un 79% Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                        "\n" +
                        "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops" +
                        "Wizner se preguntaba por qué. Por qué ella. “No había tenido síntomas previos ni había pisado un hospital en mi vida. Soy deportista. Vivo en una isla [Ibiza] con aire puro… Me preguntaba cómo era posible”. Al otro lado del teléfono, la joven declara que sentía “miedo e incertidumbre”. No es fácil, concede hoy, afrontar un diagnóstico de cáncer a esa edad: “Si lo tienes a esas edades, llegas a pensar que algo has tenido que hacer mal. Pero yo sabía que no me lo había buscado de ninguna manera”, explica.\n" +
                        "\n" +
                        "La comunidad científica todavía está intentando entender este fenómeno, desde su dimensión hasta las causas. No siempre se puede establecer una causalidad directa ante un cáncer, ni siquiera qué factores pueden estar implicados. Pero sí hay algunos puntos que los expertos ya tienen claros, como que el estilo de vida juega un papel determinante. “Los cambios en la dieta, el estilo de vida y el medio ambiente desde principios del siglo XX, que han dado lugar a un aumento de las tasas de obesidad, inactividad física, dietas occidentalizadas y contaminación ambiental, pueden haber afectado la incidencia del cáncer de aparición temprana. Además, el alcohol, el tabaquismo y las exposiciones perjudiciales durante el embarazo también pueden haber afectado”, exponen los investigadores en el artículo de BMJ Oncology.Todos esos sospechosos habituales de las consultas, como el hábito tabáquico o una alimentación poco saludable, que ya están detrás también de otras dolencias cardiovasculares o metabólicas, han ido creciendo en las últimas décadas y pueden estar pasando factura, intuyen los expertos. Ana Fernández Montes, que es vocal de la Junta Directiva de la Sociedad Española de Oncología Médica (SEOM) y oncóloga del Complexo Hospitalario Universitario de Ourense, aconseja prestar atención al exposoma. Esto es, todas las exposiciones ambientales —dieta, estilo de vida, microbioma, obesidad, medioambiente… — con las que entra en contacto un ser humano a lo largo de su vida. “Todo a lo que nos exponemos condicionará el riesgo”, avisa Fernández Montes.",
                author = "Jessica Mouzo"
            ),
            New(
                title = "La policía da por anulada la principal vía de entrada de cocaína del cartel de Los Balcanes en España",
                image = "https://imagenes.elpais.com/resizer/1vfbHrko7MddFkucFm6LiP-UStE=/1200x675/vdmedia.elpais.com/elpaistop/20239/26/20230926111139443_1695719683_asset_still.jpeg",
                description = "La policía ha dado por anulada la principal vía de entrada de cocaína del cartel de Los Balcanes en España. Tras siete inspecciones en el puerto de Valencia se han intervenido más de 1.700 kilos de cocaína ocultos en contenedores marítimos procedentes de Ecuador. En una operación conjunta de funcionarios de Vigilancia Aduanera de la Agencia Tributaria y la Policía Nacional se detectó cómo la organización habilitaba huecos en las vigas del suelo de contenedores donde se ocultaba la droga entre cajas de fruta. Pese a que la policía dio por desarticulada esta red hace dos años, la investigación ha desvelado que mantenía una infraestructura en funcionamiento,\n" +
                        "\n" +
                        "Durante la operación se ha detenido, además, a un albanés, miembro del cartel, con formación militar y altos conocimientos operativos, que iba a supervisar la transacción. Durante la investigación se han detectado los distintos modus operandi que el cartel de Los Balcanes utilizaba para ocultar la droga. La investigación se inició cuando los agentes tuvieron conocimiento de que el entramado delincuencial podría estar importando semanalmente contenedores marítimos con frutas procedentes de Ecuador, que ocultarían importantes cantidades de droga.\nLos agentes detectaron que la organización criminal ocultaba la droga de diversas formas, haciendo uso de huecos en la refrigeración de los contenedores, diseñando falsos suelos sobre los mismos o vigas con oquedades en su interior para alojar la sustancia estupefaciente.\n" +
                        "\n" +
                        "En una primera fase de la operación, que contó con la colaboración de la Guardia Civil, los investigadores detectaron las empresas que podrían estar siendo usadas por el cartel balcánico, y se comprobó cómo habían comenzado a utilizar los contenedores marítimos que entraban en España de forma regular, importando varias decenas de contenedores desde una empresa exportadora de frutas de Ecuador, con destino Valencia. El pasado junio este entramado delictivo trató de introducir una importante cantidad de cocaína que venía oculta en los compartimentos de refrigeración, interviniéndose un total de 45 kilos de cocaína y arrestando en el momento al integrante de la organización criminal. Además, fueron intervenidos tres teléfonos móviles y diverso material para la extracción de la droga de los contenedores.\n" +
                        "\n" +
                        "En la segunda fase de la operación, siguiendo con las pesquisas, se realizaron diversas inspecciones en contenedores que habían llegado al puerto de Valencia, encontrándose nuevamente con dos contenedores que escondían 44 y 46 kilos de cocaína cada uno. Además, se localizó un tercer contenedor con una sofisticada estructura, que escondía en su falso suelo 200 kilos de cocaína. Posteriormente, en la tercera fase se detectó cómo la organización criminal trataba de introducir la droga en las vigas del suelo de un contenedor, donde se intervino un total de 550 kilos de sustancia estupefaciente. Finalmente, en julio, coincidiendo con la cuarta fase de la operación, se averiguó la llegada de dos nuevos contenedores que ocultaban en el suelo de la estructura, interviniéndose entre los dos 831 kilos de cocaína.\nEl septiembre de 2021, La Policía Nacional, en colaboración con las autoridades policiales de Eslovenia, Serbia y Croacia y bajo la coordinación de la Europol (agencia policial de la Unión Europea) dio por desarticulada esta red, la mayor de Europa según los investigadores.",
                author = "El País"
            ),
            New(
                title = "La mesa como corazón de la casa",
                image = "https://imagenes.elpais.com/resizer/JXA9yjZfo0PqscPjFUkbbBHR1t8=/980x0/filters:focal(1695x3244:1705x3254)/cloudfront-eu-central-1.images.arcpublishing.com/prisa/R6RIEGTKR5HYJFBCILCTWKROTY.jpg",
                description = "Los muebles se convierten en espacios. En los nuevos proyectos de rehabilitación que Beatriz Arroyo y Lys Villalba han terminado en Madrid, una familia de muebles levanta la vivienda. ¿Cómo? “Los muebles crecen, son de talla XXL. Y se han pensado como arquitectura”, explican las arquitectas.\n" +
                        "\n" +
                        "CLemon drops soufflé cookie muffin candy canes brownie. Gummies jujubes dessert powder muffin dragée. Topping chocolate cake bonbon macaroon pudding. Toffee cheesecake candy ice cream gingerbread cookie jelly. Marzipan croissant candy icing marshmallow sweet toffee danish gummi bears. Pastry topping powder marzipan marshmallow carrot cake carrot cake halvah. Chupa chups soufflé gummies pudding carrot cake. Dragée cookie pie donut dessert marshmallow lollipop. Cake jelly marzipan gummi bears topping pastry sugar plum cake. Topping lemon drops brownie tiramisu liquorice. Cotton candy sugar plum caramels dragée jelly-o apple pie gummi bears. Pastry dragée oat cake chupa chups soufflé dessert chocolate donut. Icing lemon drops halvah croissant tiramisu jujubes oat cake. Jelly beans gummi bears liquorice lollipop candy canes donut.\n" +
                        "\n" +
                        "Pastry tiramisu halvah jelly chocolate chocolate chocolate cotton candy ice cream. Lemon drops dragée chupa chups cotton candy brownie soufflé soufflé. Donut chocolate jelly beans candy canes chocolate bar toffee caramels. Gingerbread fruitcake chocolate bar pie jujubes candy canes. Cotton candy cake cookie dessert ice cream macaroon cheesecake sesame snaps sweet. Cake croissant bear claw croissant chocolate bar caramels liquorice dragée. Cupcake soufflé halvah toffee soufflé chocolate bar gingerbread. Dessert sweet roll macaroon muffin biscuit cookie tart pudding. Pudding chocolate bar candy carrot cake gummies sesame snaps wafer bear claw wafer. Liquorice marshmallow gummi bears cookie dragée biscuit croissant toffee sugar plum. Jelly beans lollipop brownie soufflé jelly beans soufflé liquorice chocolate cake cake. Jelly cheesecake gummi bears wafer gummi bears jelly-o halvah. Brownie bonbon bonbon cupcake sesame snaps.\n" +
                        "\n" +
                        "Tart gummies biscuit brownie chocolate bonbon sweet roll. Marzipan muffin dragée cotton candy apple pie caramels gingerbread pastry biscuit. Sugar plum lemon drops pudding cheesecake wafer bonbon. Wafer jelly-o liquorice sweet roll sesame snaps jelly-o marshmallow. Gingerbread sweet toffee bonbon dragée. Jujubes biscuit candy canes candy canes liquorice bear claw pastry. Ice cream cheesecake gummies croissant pie candy jelly beans sugar plum. Fruitcake caramels sugar plum sugar plum jujubes sweet roll cheesecake. Gummi bears apple pie tootsie roll macaroon gingerbread brownie caramels gingerbread gummies. Pudding sweet roll jelly beans fruitcake caramels ice cream jelly beans chocolate. Tiramisu soufflé dragée candy canes cotton candy icing. Caramels dragée halvah gummies carrot cake cheesecake carrot cake jujubes liquorice." +
                        "En torno a ella, a un lado queda la cocina, “cuyo frente más corto se transforma en la segunda pieza de esta familia de pequeñas “arquitecturas-mueble”. Ese frente es un armario-encimera reversible, perforado por un óculo desde el que asomarse al llegar a casa.\nHacia el otro lado de la cocina, el salón es también una oficina. Allí, de nuevo, es una segunda mesa la que organiza un espacio de estudio colectivo. “Otro mueble hace de arquitectura”, sostienen. Dos apoyos laterales producidos en lámina de acero plegado y un tablero de madera de largo máximo estandarizado (366 cm) se maclan sin tornillos ni uniones, configurando un soporte de trabajo libre y colectivo. Una mesa para toda la familia. Lo de Urquiola: “Casa pequeña, mesa grande”. Como en una biblioteca, aquí se trabaja y se estudia juntos, pero en silencio.\n" +
                        "\n" +
                        "Urban Cabinets —así han llamado estas arquitectas a sus rehabilitaciones de viviendas— explora estrategias de diseño en torno a la idea de una “arquitectura-mueble”. Por eso en cada proyecto, una familia de muebles se convierte en espacio.",
                author = "Anatxu Zabalbeascoa"
            ),
            New(
                title = "La AIE cree que la demanda mundial de combustibles fósiles tocará techo antes de 2030",
                image = "https://imagenes.elpais.com/resizer/_KkxZ-33bc9MNJYFzQERrTmV4X0=/980x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/PR77IOP2DZEV3MPM27GCWINJOM.jpg",
                description = "La quema global de combustibles fósiles, el elemento clave detrás del calentamiento global, dejará atrás los aumentos ininterrumpidos desde tiempos inmemoriales para empezar a caer antes de 2030. Así lo cree, al menos, la Agencia Internacional de la Energía (AIE), que atisba un máximo en el uso de fuentes de energía sucias, “incluso sin nuevas medidas” contra la emergencia climática. En el escenario de cero emisiones netas en 2050, el requerido para evitar los escenarios más catastróficos, el descenso debería rondar el 25% en el transcurso de la presente década; algo solo factible con una electrificación masiva en el transporte y un rápido desarrollo del hidrógeno verde y los combustibles derivados de él.\n" +
                        "\n" +
                        "Porchetta pastrami biltong pork belly pancetta swine. Salami brisket kielbasa ham, ribeye tenderloin pastrami flank pig hamburger drumstick beef. Doner t-bone pork, jerky pork belly capicola sausage meatloaf corned beef cupim pig ball tip picanha kielbasa frankfurter. Tongue pastrami chislic landjaeger, t-bone pig leberkas burgdoggen spare ribs drumstick beef ribs beef pork salami. Andouille buffalo shoulder, cupim picanha turkey ball tip pork. Meatloaf jowl meatball tri-tip corned beef pastrami andouille short ribs alcatra porchetta pork loin t-bone boudin pork chop. Beef kevin landjaeger frankfurter drumstick." +
                        "\n" +
                        "Sin embargo, el ente con sede en París llama a pisar el acelerador en los países de renta media y baja. “Las políticas actuales sitúan a las economías avanzadas y a China en línea para lograr el 85% de su contribución al objetivo global [de reducción de emisiones], pero se necesitan políticas más fuertes y más apoyo internacional para los países emergentes y en vías de desarrollo”, reclama. En todos los casos, la AIE llama a acelerar la tramitación de proyectos renovables y reforzar la red: “Para cumplir el objetivo de cero emisiones netas, las líneas de transmisión y distribución tienen que crecer en alrededor de dos millones de kilómetros cada año de aquí a 2030″.\n" +
                        "\n" +
                        "Sigue toda la información de Economía y Negocios en Facebook y X, o en nuestra newsletter semanal",
                author = "Ignacio Fariza"
            ),
            New(
                title = "Velo 7: el velocímetro de bici más popular en Amazon, ahora rebajado",
                image = "https://imagenes.elpais.com/resizer/jAZZCTSRxnjAi8Kd0zubrGRkpv8=/980x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/NBMBKZFURBGPXGLK6D56SRF6HY.png",
                description = "Cualquier época del año es fantástica para montar en bici. En la actualidad, mucha gente recurre a ella para salvar la distancia que le separa de casa al trabajo, incluirla en su rutina de entrenamiento o pasear con ella en sus planes de ocio. Por eso mismo, si lo que deseamos es conocer con exactitud los kilómetros recorridos en estos trayectos, nada mejor que elegir un velocímetro o cuentakilómetros para bicicleta. En Amazon, hemos dado con el modelo con cable de la marca CatEye, cuyo nombre es Velo 7, ahora rebajado un 24%.\n" +
                        "\n" +
                        "Un accesorio de deporte que resulta muy sencillo de utilizar y que se ha aupado entre los productos más vendidos entre los ciclocomputadores de la plataforma online. Su nota media es de 4,5 sobre 5 estrellas y supera las 4.700 valoraciones.\n¿Cuáles son las ventajas de usar un velocímetro para bicicleta?\n" +
                        "\n" +
                        "Al margen de los elementos que podemos utilizar al montar seguros en bici (como el casco, un buen sistema de luces o un candado a prueba de intrusos), un velocímetro de este tipo nos muestra de un simple vistazo no solo la distancia recorrida, sino otros parámetros de interés:\n" +
                        "\n" +
                        "    Porchetta pastrami biltong pork belly pancetta swine. Salami brisket kielbasa ham, ribeye tenderloin pastrami flank pig hamburger drumstick beef. Doner t-bone pork, jerky pork belly capicola sausage meatloaf corned beef cupim pig ball tip picanha kielbasa frankfurter. Tongue pastrami chislic landjaeger, t-bone pig leberkas burgdoggen spare ribs drumstick beef ribs beef pork salami. Andouille buffalo shoulder, cupim picanha turkey ball tip pork. Meatloaf jowl meatball tri-tip corned beef pastrami andouille short ribs alcatra porchetta pork loin t-bone boudin pork chop. Beef kevin landjaeger frankfurter drumstick.\n" +
                        "\n" +
                        "En el caso del velocímetro de bicicleta CatEye Velo 7, los usuarios que ya lo han probado valoran muchísimo su función de temporizador, la precisión de la pedalada o su facilidad de montaje: “Funcionamiento correcto tras el primer mes de uso. Muy recomendable. A pesar de ser con cable es muy fácil de instalar y configurar”, asegura uno de ellos.\nAunque el auge de los cuentakilómetros sin cable para bici es un hecho, si lo que estamos buscando es un producto de fácil instalación y de uso intuitivo, este modelo alámbrico de CatEye es el más indicado. Velo 7 es un accesorio de dimensiones muy reducidas pero con una amplia pantalla donde sus números son legibles y se aprecian desde cualquier ángulo.\n" +
                        "\n" +
                        "Además, sus siete funciones cubrirán las exigencias de un usuario medio (incluido público juvenil) y en ellas se muestran la velocidad actual, la máxima y la media; además de la distancia del viaje, la distancia total, el tiempo transcurrido y el reloj. “Tiene las mismas funciones que el anterior, no necesito más; ni creo que lo necesite la mayor parte de los practicantes de mountain bike”, sostiene un segundo usuario.\n" +
                        "\n" +
                        "¿Qué mejora diferencial incorpora? Con el renovado Velo 7 tendremos la capacidad de insertar los kilómetros totales desde que empezamos a rodar el primer día y tras el cambio de pila, sin arriesgarnos a perder este dato tan vital.",
                author = ""
            ), New(
                title = "En el trabajo no hay que darlo todo: la regla del 85%",
                image = "https://imagenes.elpais.com/resizer/PyJ-axov637n8CNxhA9G43ILmNg=/1200x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/6SJJ6DTRH5EINDNH4JJKKHFHKA.jpg",
                description = "Cualquier época del año es fantástica para montar en bici. En la actualidad, mucha gente recurre a ella para salvar la distancia que le separa de casa al trabajo, incluirla en su rutina de entrenamiento o pasear con ella en sus planes de ocio. Por eso mismo, si lo que deseamos es conocer con exactitud los kilómetros recorridos en estos trayectos, nada mejor que elegir un velocímetro o cuentakilómetros para bicicleta. En Amazon, hemos dado con el modelo con cable de la marca CatEye, cuyo nombre es Velo 7, ahora rebajado un 24%.\n" +
                        "\n" +
                        "Un accesorio de deporte que resulta muy sencillo de utilizar y que se ha aupado entre los productos más vendidos entre los ciclocomputadores de la plataforma online. Su nota media es de 4,5 sobre 5 estrellas y supera las 4.700 valoraciones.\n¿Cuáles son las ventajas de usar un velocímetro para bicicleta?\n" +
                        "\n" +
                        "Al margen de los elementos que podemos utilizar al montar seguros en bici (como el casco, un buen sistema de luces o un candado a prueba de intrusos), un velocímetro de este tipo nos muestra de un simple vistazo no solo la distancia recorrida, sino otros parámetros de interés:\n" +
                        "\n" +
                        "Porchetta pastrami biltong pork belly pancetta swine. Salami brisket kielbasa ham, ribeye tenderloin pastrami flank pig hamburger drumstick beef. Doner t-bone pork, jerky pork belly capicola sausage meatloaf corned beef cupim pig ball tip picanha kielbasa frankfurter. Tongue pastrami chislic landjaeger, t-bone pig leberkas burgdoggen spare ribs drumstick beef ribs beef pork salami. Andouille buffalo shoulder, cupim picanha turkey ball tip pork. Meatloaf jowl meatball tri-tip corned beef pastrami andouille short ribs alcatra porchetta pork loin t-bone boudin pork chop. Beef kevin landjaeger frankfurter drumstick.\n" +
                        "\n" +
                        "En el caso del velocímetro de bicicleta CatEye Velo 7, los usuarios que ya lo han probado valoran muchísimo su función de temporizador, la precisión de la pedalada o su facilidad de montaje: “Funcionamiento correcto tras el primer mes de uso. Muy recomendable. A pesar de ser con cable es muy fácil de instalar y configurar”, asegura uno de ellos.\nAunque el auge de los cuentakilómetros sin cable para bici es un hecho, si lo que estamos buscando es un producto de fácil instalación y de uso intuitivo, este modelo alámbrico de CatEye es el más indicado. Velo 7 es un accesorio de dimensiones muy reducidas pero con una amplia pantalla donde sus números son legibles y se aprecian desde cualquier ángulo.\n" +
                        "\n" +
                        "Además, sus siete funciones cubrirán las exigencias de un usuario medio (incluido público juvenil) y en ellas se muestran la velocidad actual, la máxima y la media; además de la distancia del viaje, la distancia total, el tiempo transcurrido y el reloj. “Tiene las mismas funciones que el anterior, no necesito más; ni creo que lo necesite la mayor parte de los practicantes de mountain bike”, sostiene un segundo usuario.\n" +
                        "\n" +
                        "¿Qué mejora diferencial incorpora? Con el renovado Velo 7 tendremos la capacidad de insertar los kilómetros totales desde que empezamos a rodar el primer día y tras el cambio de pila, sin arriesgarnos a perder este dato tan vital.",
                author = "Porchetta pastrami"
            ), New(
                title = "La Fiscalía acusa a Shakira de defraudar otros seis millones en 2018 al simular la cesión de sus derechos a empresas fantasma",
                image = "https://imagenes.elpais.com/resizer/0tPrM1t0SpUcp38bs0z6LpvkdGo=/980x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/TC3I6IS7ZTRT77UVLUHRBS66KI.jpg",
                description = "Shakira defraudó presuntamente otros seis millones Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                        "\n" +
                        "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops" +
                        "La querella recuerda que, en 2018, Shakira residía en una casa Esplugues de Llobregat (Barcelona) junto al exdefensa del Barça Gerard Piqué y los dos hijos de ambos, por lo que debía pagar la totalidad de sus impuestos en España. En la declaración de ese ejercicio, sin embargo, eludió mencionar parte de los millonarios ingresos que percibió. Shakira Isabel Mebarak Ripoll “se sirvió de un entramado societario” y se dedujo gastos “que no procedían”, siempre según la acusación de la Fiscalía. La cantante omitió declarar, especialmente, los 12,5 millones de dólares con ocasión de la gira musical El Dorado, que entre junio y noviembre de ese año le llevó a dar 53 conciertos en 22 países, sobre todo en Europa, Estados Unidos y América Latina.",
                author = "Jesús García Bueno"
            ),
            New(
                title = "Port Aventura triplica el beneficio hasta 30 millones tras lograr ingresos récord en 2022",
                image = "https://imagenes.elpais.com/resizer/oH1EE-NZ9hIcX_JkFjat4Vl57Qw=/1200x0/filters:focal(445x284:455x294)/cloudfront-eu-central-1.images.arcpublishing.com/prisa/F5CKDGJGIRIB7OIR6FEVB57O3Y.jpg",
                description = "Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                        "\n" +
                        "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                author = "Cristina Galindo"
            )
        )
    }

}