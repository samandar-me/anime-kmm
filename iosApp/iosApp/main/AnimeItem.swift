//
//  AnimeItem.swift
//  iosApp
//
//  Created by Macbook on 20/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AnimeItem: View {
    let anime: Anime
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
        
            ZStack {
                AsyncImage(url: URL(string: anime.image)){image in
                    image.resizable()
                }placeholder: {
                    Color.gray
                }
            }   .frame(maxWidth: .infinity, idealHeight: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(anime.kanji)
                .font(.title3)
                .fontWeight(.bold)
                .lineLimit(1)
            
            Text(anime.name)
                .font(.headline)
            
            
        }
        .frame(maxWidth: .infinity, maxHeight: 260)
        .padding(8)
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                      .stroke(.gray, lineWidth: 2)
        )
    }
}
