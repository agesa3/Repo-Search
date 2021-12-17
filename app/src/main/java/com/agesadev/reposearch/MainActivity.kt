package com.agesadev.reposearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agesadev.reposearch.adapter.ReposAdapter
import com.agesadev.reposearch.models.Repo

class MainActivity : AppCompatActivity() {

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.repoRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val sampleData = listOf<Repo>(
            Repo("Repo 1"),
            Repo("Repo 2"),
            Repo("Repo 3"),
            Repo("Repo 4"),
            Repo("Repo 5"),
            Repo("Repo 6"),
            Repo("Repo 7"),
            Repo("Repo 8"),
            Repo("Repo 9"),
            Repo("Repo 10"),
            Repo("Repo 1"),
            Repo("Repo 2"),
            Repo("Repo 3"),
            Repo("Repo 4"),
            Repo("Repo 5"),
            Repo("Repo 6"),
            Repo("Repo 7"),
            Repo("Repo 8"),
            Repo("Repo 9"),
            Repo("Repo 10")
        )

        adapter.submitList(sampleData)

    }
}