package com.example.finema.databinding;
import com.example.finema.R;
import com.example.finema.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MovieDetailsFragmentBindingImpl extends MovieDetailsFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.filmLoader, 5);
        sViewsWithIds.put(R.id.layout, 6);
        sViewsWithIds.put(R.id.imageView, 7);
        sViewsWithIds.put(R.id.layoutText, 8);
        sViewsWithIds.put(R.id.textView3, 9);
        sViewsWithIds.put(R.id.textView6, 10);
        sViewsWithIds.put(R.id.textView8, 11);
        sViewsWithIds.put(R.id.rating, 12);
        sViewsWithIds.put(R.id.textView7, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MovieDetailsFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private MovieDetailsFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[11]
            );
        this.companies.setTag(null);
        this.filmTitle.setTag(null);
        this.genres.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.overview.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.filmId == variableId) {
            setFilmId((com.example.finema.models.movieResponse.MovieDetails) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFilmId(@Nullable com.example.finema.models.movieResponse.MovieDetails FilmId) {
        this.mFilmId = FilmId;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.filmId);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String filmIdTitle = null;
        java.lang.String filmIdOverview = null;
        java.lang.String filmIdStringGenres = null;
        com.example.finema.models.movieResponse.MovieDetails filmId = mFilmId;
        java.lang.String filmIdStringCompanies = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (filmId != null) {
                    // read filmId.title
                    filmIdTitle = filmId.getTitle();
                    // read filmId.overview
                    filmIdOverview = filmId.getOverview();
                    // read filmId.stringGenres
                    filmIdStringGenres = filmId.getStringGenres();
                    // read filmId.stringCompanies
                    filmIdStringCompanies = filmId.getStringCompanies();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.companies.setText(filmIdStringCompanies);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.filmTitle, filmIdTitle);
            this.genres.setText(filmIdStringGenres);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.overview, filmIdOverview);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): filmId
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}