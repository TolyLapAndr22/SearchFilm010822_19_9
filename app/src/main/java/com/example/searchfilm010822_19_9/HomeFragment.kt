package com.example.searchfilm010822_19_9

import FilmListRecyclerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter


    val filmsDataBase = listOf(
        Film("The Shawshank Redemption", R.drawable.film_24_1, "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."),
        Film("The Godfather", R.drawable.film_24_2, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."),
        Film("The Dark Knight", R.drawable.film_24_3, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."),
        Film("Pulp Fiction", R.drawable.film_24_4, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."),
        Film("Inception", R.drawable.film_24_5, "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."),
        Film("Hamilton", R.drawable.film_24_6, "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast."),
        Film("Gisaengchung", R.drawable.film_24_7, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."),
        Film("Interstellar", R.drawable.film_24_8, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."),
        Film("Joker", R.drawable.film_24_9, "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker."),
        Film("1917", R.drawable.film_24_10, "April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.")

    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        //???????????????????? ?????????????????? ?????????????????? ???????????????????? ???????????? ?? ????????????
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //???????? ?????????? ???????????????????????? ?????? ?????????????? ???????????? "??????????" ???? ???????? ????????????????????
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //???????? ?????????? ???????????????????????? ???? ???????????? ?????????????????? ????????????
            override fun onQueryTextChange(newText: String): Boolean {
                //???????? ???????? ???????? ???? ?????????????????? ?? ?????????????? ?????? ????
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //?????????????????? ???????????? ???? ???????????? ???????????????????? ??????????????????
                val result = filmsDataBase.filter {
                    //?????????? ?????? ???????????????? ??????????????????, ?????????? ?? ?????????????? ?? ?????? ???????????? ?????????????????? ?? ?????????????? ????????????????
                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                //?????????????????? ?? ??????????????
                filmsAdapter.addItems(result)
                return true
            }
        })

        //?????????????? ?????? RV
        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //?????????????????????? ??????????????
            adapter = filmsAdapter
            //?????????????? layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //?????????????????? ?????????????????? ?????? ????????????????
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //???????????? ???????? ???? ?? RV
        filmsAdapter.addItems(filmsDataBase)
    }

}