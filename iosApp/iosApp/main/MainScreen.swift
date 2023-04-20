//
//  MainScreen.swift
//  iosApp
//
//  Created by Macbook on 20/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainScreen: View {
    @StateObject var viewModel = MainViewModel()
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
  
    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVGrid(columns: gridColumns, spacing: 16) {
                    ForEach(viewModel.animes, id: \.id) { anime in
                        NavigationLink(value: anime) {
                            AnimeItem(anime: anime)
                        }.buttonStyle(PlainButtonStyle())
                    }
                    if viewModel.isLoading {
                        Section(footer: ProgressView()) { }
                    }
                }
                .padding(.horizontal,12)
                .navigationDestination(for: Anime.self) { anime in
                    DetailScreen(anime: anime)
                }
            }.navigationTitle("Anime Characters")
        }.task {
            await viewModel.loadCharacters()
        }
    }
}

