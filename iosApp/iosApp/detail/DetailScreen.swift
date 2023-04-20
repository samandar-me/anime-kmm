//
//  DetailScreen.swift
//  iosApp
//
//  Created by Macbook on 20/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import SwiftUI

struct DetailScreen: View {
    let anime: Anime
    var body: some View {
        ScrollView {
            VStack {
                ZStack {
                    AsyncImage(url: URL(string: anime.image)) { image in
                        image.resizable()
                    }placeholder: {
                        ProgressView()
                    }
                }
                .frame(maxWidth: .infinity,minHeight: 300, maxHeight: 300)
                
                              VStack(alignment:.leading, spacing: 12){
                                  Text(anime.kanji)
                                      .font(.title)
                                      .fontWeight(.bold)
                                      .fixedSize(horizontal: false, vertical: true)
                                  
                                  Text(anime.name)
                                      .font(.title2)
                                  
                                  Text(anime.about)
                                      .font(.body)
                                      .fixedSize(horizontal: false, vertical: true)
                                  
                                  Button(action: {
                                      if let url = URL(string: anime.url) {
                                          UIApplication.shared.open(url)
                                      }
                                  }){
                                      Text("Go to website")
                                          .foregroundColor(.black)
                                  }
                                  .frame(maxWidth: .infinity, maxHeight: 40)
                                  .padding()
                                  .background(.green)
                                  .clipShape(RoundedRectangle(cornerRadius: 8))
                                  
                              }
                              .padding(15)
                
            }.frame(maxWidth: .infinity,maxHeight: .infinity)
        }
    }
}
