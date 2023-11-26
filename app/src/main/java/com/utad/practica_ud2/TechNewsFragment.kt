package com.utad.practica_ud2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.practica_ud2.databinding.FragmentSportNewsBinding
import com.utad.practica_ud2.databinding.FragmentTechNewsBinding

class TechNewsFragment : Fragment() {

    private lateinit var _binding : FragmentTechNewsBinding
    private val binding : FragmentTechNewsBinding get() = _binding

    private var techNewsList : MutableList<New> = mutableListOf()

    private lateinit var adapter: NewListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        techNewsList.addAll(getTechNewsList())
        binding.rvTechNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = NewListAdapter(requireContext()) {new -> navigateToDetailActivity(new)}

        binding.rvTechNews.adapter = adapter
        adapter.submitList(techNewsList)
    }

    private fun navigateToDetailActivity(selectedNew: New) {

        val direction = TechNewsFragmentDirections.actionTechNewsFragmentToDetailNewActivity(selectedNew)
        findNavController().navigate(direction)
    }


    companion object {
        fun getTechNewsList(): List<New> {
            return listOf(
                New(
                    title = "Whatsapp Web, Facebook, Instagram y otros servicios de Meta sufren una caída en su entorno web",
                    image = "https://phantom-elmundo.unidadeditorial.es/c9f88ff9118eba9f6143803de38c9e77/crop/0x0/1200x800/resize/473/f/webp/assets/multimedia/imagenes/2023/09/22/16953671065506.jpg",
                    description = "Whatsapp Web, Facebook, Instagram y otros servicios de Meta sufren una caída en su entorno web. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Juan Morenilla"
                ),
                New(
                    title = "El 64% de la población de España posee competencias digitales básicas, por encima del 54% de la UE",
                    image = "https://phantom-elmundo.unidadeditorial.es/4c787d078ed96018a40a47117d025ea4/crop/0x0/1772x1181/resize/473/f/webp/assets/multimedia/imagenes/2023/09/21/16952906415047.jpg",
                    description = "El 64% de la población de España posee competencias digitales . Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" + "El 64% de la población de España posee competencias digitales . Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Etootsie roll"
                ),
                New(
                    title = "OpenAI ya tiene lista la tercera versión de DALL-E, su inteligencia artificial más creativa",
                    image = "https://phantom-elmundo.unidadeditorial.es/5fc01fc3390fef6e24e4bb53b2859f5f/crop/3x0/1260x838/resize/473/f/webp/assets/multimedia/imagenes/2023/09/21/16952513976755.png",
                    description = "OpenAI ya tiene lista la tercera versión de DALL-E, su inteligencia artificial más creativa. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" + "OpenAI ya tiene lista la tercera versión de DALL-E, su inteligencia artificial más creativa. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" + "OpenAI ya tiene lista la tercera versión de DALL-E, su inteligencia artificial más creativa. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "ÁNGEL JIMÉNEZ DE LUIS "
                ),
                New(
                    title = "Amazon actualiza Alexa y la hace más conversacional gracias a la inteligencia artificial",
                    image = "https://phantom-elmundo.unidadeditorial.es/10ac4480c105b9fcf5b66667e1f66f9e/crop/8x31/905x630/resize/473/f/webp/assets/multimedia/imagenes/2023/09/20/16952309613028.jpg",
                    description = "Amazon actualiza Alexa y la hace más conversacional gracias a la inteligencia artificial. Amazon actualiza Alexa y la hace más conversacional gracias a la inteligencia artificial. Amazon actualiza Alexa y la hace más conversacional gracias a la inteligencia artificial.\nMarzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Alexa"
                ),
                New(
                    title = "Así es el iPhone 15: una apuesta sólida para actualizarse",
                    image = "https://k-vod.uecdn.es/html5/html5lib/v2.89.0_ue/modules/KalturaSupport/thumbnail.php/p/108/uiconf_id/14969378/entry_id/0_88loch9f/height/302?",
                    description = "Así es el iPhone 15: Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +"Así es el iPhone 15: Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\nujubes biscuit chupa chups" + "Así es el iPhone 15: Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\nujubes biscuit chupa chups" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Jhon Doe"
                ),
                New(
                    title = "Se filtran un nuevo modelo de Xbox Series X y los próximos lanzamientos de Microsoft",
                    image = "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2022/12/xbox-series-xs-2903174.jpg?tf=1200x",
                    description = "Se filtran un nuevo modelo de Xbox Series X y los próximos lanzamientos de MicrosoftMarzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\nart gummies biscuit brownie chocolate bonbon sweet roll. Marzipan muffin dragée cotton candy apple pie caramels gingerbread pastry biscuit. Sugar plum lemon drops pudding cheesecake wafer bonbon. Wafer jelly-o liquorice sweet roll sesame snaps jelly-o marshmallow. Gingerbread sweet toffee bonbon dragée. Jujubes biscuit candy canes candy canes liquorice bear claw pastry. Ice cream cheesecake gummies croissant pie candy jelly beans sugar plum. Fruitcake caramels sugar plum sugar plum jujubes sweet roll cheesecake. Gummi bears apple pie tootsie roll macaroon gingerbread brownie caramels gingerbread gummies. Pudding sweet roll jelly beans fruitcake caramels ice cream jelly beans chocolate. Tiramisu soufflé dragée candy canes cotton candy icing. Caramels dragée halvah gummies carrot cake cheesecake carrot cake jujubes liquo." +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Jhon Doe"
                )
            )

        }
    }

}