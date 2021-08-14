package com.example.recyclerviewapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pokemonList = listOf(
            "ピカチュウ",
            "カイリュー",
            "ヤドラン",
            "ピジョン",
            "コダック",
            "コラッタ",
            "ズバット",
            "ギャロップ",
            "サンダース",
            "メノクラゲ",
            "パウワウ",
            "カラカラ",
            "タマタマ",
            "ガラガラ",
            "フシギダネ"
        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyRecyclerViewAdapter(pokemonList)
        recyclerView.adapter = MyRecyclerViewAdapter(pokemonList)

        adapter.setOnItemClickListener(View.OnClickListener { view ->
            val pokemonName = view.findViewById<TextView>(R.id.title)
            val pokemonName1 = pokemonName.text.toString()
            Toast.makeText(this@MainActivity, pokemonName1, Toast.LENGTH_LONG).show()

        })
    }
    interface OnItemClickListener {
        fun onItemClick(view: View?)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val positionText: TextView
        val titleText: TextView
        init {
            positionText = itemView.findViewById(R.id.position)
            titleText = itemView.findViewById(R.id.title)
        }
    }
    class MyRecyclerViewAdapter(val list: List<String>) : RecyclerView.Adapter<MyViewHolder>() {
        private var listener: View.OnClickListener? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.positionText.text = position.toString()
            holder.titleText.text = list[position]
        }
        override fun getItemCount(): Int = list.size
        fun setOnItemClickListener(listener: View.OnClickListener) {
            this.listener = listener
        }
    }

}


