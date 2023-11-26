package com.utad.practica_ud2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.practica_ud2.databinding.FragmentSportNewsBinding

class SportNewsFragment : Fragment() {

    private lateinit var _binding : FragmentSportNewsBinding
    private val binding : FragmentSportNewsBinding get() = _binding

    private var sportNewsList : MutableList<New> = mutableListOf()

    private lateinit var adapter: NewListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSportNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sportNewsList.addAll(getSportsNewsList())
        binding.rvSportNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = NewListAdapter(requireContext()) {new -> navigateToDetailActivity(new)}

        binding.rvSportNews.adapter = adapter
        adapter.submitList(sportNewsList)
    }

    private fun navigateToDetailActivity(selectedNew: New) {

        val direction = SportNewsFragmentDirections.actionSportNewsFragmentToDetailNewActivity(selectedNew)
        findNavController().navigate(direction)
    }


    companion object {
        fun getSportsNewsList(): List<New> {
            return listOf(
                New(
                    title = "Gavi o el jugador total que evoca a Deco y a Messi.",
                    image = "https://imagenes.elpais.com/resizer/Qu_ubs5JcjCzFPr8Iim6rTiErIs=/1200x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/77TQCQYIQNDPBLE2WPFZ3DU5WQ.jpg",
                    description = "Gavi o el jugador total que evoca a Deco y a Messi.Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Bujubes biscuit"
                ),New(
                    title = "Carlota Ciganda, cuando el golf le ganó al fútbol",
                    image = "https://imagenes.elpais.com/resizer/zyPJwTRsViIsyPdMtbGV4MasN3Q=/1200x0/filters:focal(4180x2305:4190x2315)/cloudfront-eu-central-1.images.arcpublishing.com/prisa/YOS2UD6HQZDZ5A6RFSYCQWH7YU.jpg",
                    description = "La golfista navarra, de una familia futbolista, se consagra como la gran líder que dio a Europa una histórica Solheim. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Juan Morenilla"
                ),New(
                    title = "Demolición a cabezazos del Atlético al Real Madrid",
                    image = "https://imagenes.elpais.com/resizer/lzZqeuq4ZGTuO6XD2Zzymx_lFFk=/1200x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/FHYC5BDYARGYDGI4HPBNEXTFIU.jpg",
                    description = "Los rojiblancos se imponen a los de Ancelotti, debilitados con Modric y Kroos de inicio y sometidos por el planteamiento sólido de Simeone y el punzante Samu Lino\n" +
                            "Morata marca el tercer gol del Atlético al Real Madrid en el Metropolitano. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "David Álvarez"
                ),New(
                    title = "El paso de gigante para Ferrari en Suzuka... aunque no lo parezca",
                    image = "https://phantom-marca.unidadeditorial.es/c4293e9735a52f34b0c743cdff3679b2/resize/660/f/webp/assets/multimedia/imagenes/2023/09/25/16956504920013.jpg",
                    description = "El paso de gigante para Ferrari en Suzuka... aunque no lo parezca. Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "MARCO CANSECO"
                ),New(
                    title = "Hamilton no entendió las decisiones de Mercedes en su lucha con Russell",
                    image = "https://phantom-marca.unidadeditorial.es/0a86ed4fa3745a5c7f8f2293dbfd81bd/resize/660/f/webp/assets/multimedia/imagenes/2023/09/25/16956382635218.jpg",
                    description = "Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "PAULA ANTÓN"
                ),
                New(
                    title = "CA Osasuna vs Atlético de Madrid: estadísticas y pronósticos",
                    image = "https://phantom-marca.unidadeditorial.es/08b6b0d3fb0946f3a404d9cf7f0078bd/resize/660/f/webp/assets/multimedia/imagenes/2023/09/27/16958007244997.jpg",
                    description = "Marzipan brownie toffee lollipop tootsie roll. Ice cream marshmallow croissant gingerbread candy pie sweet gummi bears biscuit. Jelly beans macaroon soufflé pudding chocolate cake. Bonbon chocolate marshmallow powder gummies. Lemon drops topping macaroon apple pie chocolate. Gummi bears jelly soufflé marshmallow wafer fruitcake lollipop jujubes chocolate. Lemon drops cheesecake sugar plum sweet jelly gingerbread. Apple pie candy canes macaroon lollipop chocolate cake sesame snaps tiramisu. Sesame snaps caramels tiramisu bear claw lemon drops candy canes pie. Candy chocolate bar chupa chups jelly ice cream jelly croissant. Pie shortbread donut cotton candy croissant chocolate cake croissant ice cream. Oat cake halvah toffee lemon drops marzipan caramels sugar plum. Bonbon gingerbread gummies cupcake donut pie tiramisu marzipan. Marzipan jujubes danish ice cream oat cake sweet.\n" +
                            "\n" +
                            "Jujubes biscuit chupa chups tootsie roll jelly-o. Cheesecake topping soufflé danish marshmallow. Topping cookie donut topping apple pie cookie danish. Marshmallow lemon drops fruitcake liquorice fruitcake fruitcake gummies croissant lemon drops. Candy tootsie roll carrot cake lemon drops croissant cake biscuit. Shortbread gummies dragée cupcake croissant. Marzipan ice cream muffin gummies cheesecake marzipan macaroon topping. Gingerbread cake sesame snaps caramels caramels. Powder gummies gingerbread cake sweet carrot cake. Toffee gingerbread marzipan halvah jelly beans liquorice croissant. Sweet jelly dragée cookie pie fruitcake toffee soufflé. Shortbread carrot cake biscuit chocolate icing caramels sweet roll tart. Caramels dessert cookie marzipan powder wafer. Gummi bears sweet roll powder marzipan jelly-o dessert biscuit lemon drops",
                    author = "Juan Morenilla"
                )
            )
        }
    }

}