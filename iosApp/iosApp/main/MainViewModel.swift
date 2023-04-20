//
//  MainViewModel.swift
//  iosApp
//
//  Created by Macbook on 20/04/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension MainScreen {
    @MainActor class MainViewModel: ObservableObject {
        private let useCase = GetAllCharactersUseCase.init()
        
        @Published private (set) var animes: [Anime] = []
        @Published private (set) var isLoading: Bool = true
        
        func loadCharacters() async {
            do {
                let characters = try await useCase.invoke(parameter: KotlinUnit.init())
                self.animes = characters
                isLoading = false
            } catch {
                isLoading = false
            }
        }
    }
}
