package com.userhabit.todo.todoapp.util;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.util.DiffUtil;

import com.userhabit.todo.todoapp.data.PictureDetailRepository;
import com.userhabit.todo.todoapp.domain.GetPictureDetailUseCase;
import com.userhabit.todo.todoapp.domain.GetPicturesUseCaseParameters;
import com.userhabit.todo.todoapp.ui.detail.PictureDetailViewModelFactory;
import com.userhabit.todo.todoapp.ui.picture.PhotoDiffCallback;
import com.userhabit.todo.todoapp.ui.picture.PictureRecyclerAdapter;
import com.userhabit.todo.todoapp.ui.picture.PictureViewModelFactory;

public class InjectionUtils {

    //viewmodel factory
    public static ViewModelProvider.Factory pictureViewModelFactory() {
        return new PictureViewModelFactory(InjectionUseCaseUtils.provideGetPictureUseCase());
    }

    public static ViewModelProvider.Factory providePictureDetailViewModelFactory(GetPictureDetailUseCase pictureDetailUseCase) {
        return new PictureDetailViewModelFactory(pictureDetailUseCase);
    }

    //parameter
    public static GetPicturesUseCaseParameters providePictureUseCaseParameter() {
        return new GetPicturesUseCaseParameters("cat", 1, 0, 50);
    }

    public static PictureRecyclerAdapter providePictureRecyclerAdapter() {
        return new PictureRecyclerAdapter(InjectionUtils.provideDiffUtilCallback());
    }

    public static DiffUtil.ItemCallback provideDiffUtilCallback() {
        return new PhotoDiffCallback();
    }
}