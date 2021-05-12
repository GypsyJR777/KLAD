package com.example.finema.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JD\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00100\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011JJ\u0010\u0012\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00132\u001e\u0010\f\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0013\u0012\u0004\u0012\u00020\u00100\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011JD\u0010\u0014\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00100\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/finema/util/Coroutines;", "", "()V", "dataSet", "Ljava/util/ArrayList;", "Lcom/example/finema/models/movieResponse/Movie;", "movie", "Lcom/example/finema/models/movieResponse/MovieDetails;", "resp", "Lcom/example/finema/models/movieResponse/MovieResponse;", "ioThenMain", "Lkotlinx/coroutines/Job;", "work", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "callback", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "ioThenMan", "T", "movieDetailsThenMain", "app_debug"})
public final class Coroutines {
    private static final java.util.ArrayList<com.example.finema.models.movieResponse.Movie> dataSet = null;
    private static com.example.finema.models.movieResponse.MovieResponse resp;
    private static com.example.finema.models.movieResponse.MovieDetails movie;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.util.Coroutines INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job ioThenMain(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse>, ? extends java.lang.Object> work, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.finema.models.movieResponse.MovieResponse, kotlin.Unit> callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>kotlinx.coroutines.Job ioThenMan(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> work, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job movieDetailsThenMain(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieDetails>, ? extends java.lang.Object> work, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.finema.models.movieResponse.MovieDetails, kotlin.Unit> callback) {
        return null;
    }
    
    private Coroutines() {
        super();
    }
}