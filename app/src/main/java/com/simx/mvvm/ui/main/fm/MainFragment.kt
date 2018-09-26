package com.simx.mvvm.ui.main.fm

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.simx.mvvm.R
import com.simx.mvvm.data.PintroMenuItem
import com.simx.mvvm.databinding.MainFragmentBinding
import com.simx.mvvm.ui.main.adapter.AdapterMenu
import com.simx.mvvm.ui.main.vm.MainViewModel

class MainFragment : Fragment(), AdapterMenu.onAdapterClicked {
    override fun onAdapterMenuClicked(pintroMenuItem: PintroMenuItem) {
        Toast.makeText(this.context,"Menu clicked ${pintroMenuItem.name}",Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var adapterMenu: AdapterMenu
    lateinit var mainFragmentBinding: MainFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mainFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.main_fragment,container, false)
        return mainFragmentBinding.root
    }

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapterMenu   = AdapterMenu(listOf(), this)
        mainFragmentBinding.rcvManu.setHasFixedSize(true)
        mainFragmentBinding.rcvManu.layoutManager = LinearLayoutManager(this.context)
        mainFragmentBinding.rcvManu.adapter = adapterMenu
        viewModel.gdataMenu()?.subscribe (
                {adapterMenu.setMenu(it.pintroMenu)},
                { Log.e("","Error  ${it.message}")}
        )
    }

}
