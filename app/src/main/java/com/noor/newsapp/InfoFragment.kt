package com.noor.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.noor.newsapp.databinding.FragmentInfoBinding
import com.noor.newsapp.presentation.viewModel.NewsViewModel

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        binding.wvInfo.apply {
            webViewClient = WebViewClient()
            if (article.url != null){
                loadUrl(article.url)
            }
        }
        viewModel = (activity as MainActivity).viewModel
        binding.floatButtonSave.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Saved Successfully!", Snackbar.LENGTH_LONG).show()
        }
    }

}