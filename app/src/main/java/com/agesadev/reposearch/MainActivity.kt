package com.agesadev.reposearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agesadev.reposearch.adapter.ReposAdapter
import com.agesadev.reposearch.models.Repo
import com.agesadev.reposearch.network.SearchResult
import com.agesadev.reposearch.network.createGithubApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ReposAdapter { repo ->
            RepoDetailsActivity.startActivity(this, repo)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.repoRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val service = createGithubApiService()
        service.searchRepositories("android").enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val repos = response.body()?.items.orEmpty()
                adapter.submitList(repos)
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Toast.makeText(this@MainActivity, "An error Occurred", Toast.LENGTH_SHORT).show()
            }

        })

    }
}