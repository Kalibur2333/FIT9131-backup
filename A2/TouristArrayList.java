import java.util.ArrayList;

public class TouristArrayList {
    private ArrayList<TouristGroup> groupArrayList;
    //constructor, also creates groups.
    public TouristArrayList(int numOfGroup)
    {
        groupArrayList = new ArrayList<>();
        for (int i = 0; i < numOfGroup; i ++)
        {
            groupArrayList.add(new TouristGroup());
        }
    }

    //count selfies for display.
    public int countVideo()
    {
        int video = 0;
        for (TouristGroup each: groupArrayList)
        {
            if (each.getType().equals(IndividualPhoto.TYPE))
                video ++;
        }
        return video;
    }

    public int countPhoto()
    {
        int photo = 0;
        for (TouristGroup each: groupArrayList)
        {
            if (each.getType().equals(IndividualVideo.TYPE))
                photo ++;
        }
        return photo;
    }

    public int countSketch()
    {
        int sketch = 0;
        for (TouristGroup each: groupArrayList)
        {
            if (each.getType().equals(IndividualSketch.TYPE))
                sketch ++;
        }
        return sketch;
    }

    public int countGroupPhoto()
    {
        int gPhoto = 0;
        for (TouristGroup each: groupArrayList)
        {
            if (each.getType().equals(GroupPhoto.TYPE))
                gPhoto ++;
        }
        return gPhoto;
    }

    public int countGroupVideo()
    {
        int gVideo = 0;
        for (TouristGroup each: groupArrayList)
        {
            if (each.getType().equals(GroupVideo.TYPE))
                gVideo ++;
        }
        return gVideo;
    }
    //get number of groups
    public int getNumOfGroup()
    {
        return groupArrayList.size();
    }
    //get one group to TouristGroup
    public TouristGroup getOne (int i)
    {
        return groupArrayList.get(i);
    }
}
