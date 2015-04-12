# yd
ReadMe:
1. 编译：
   ant clean
   ant
   ant zip #打包源代码
2. 使用：
   参照com.edong.utils.TestConvertJsonToTrack中的代码
   主要就两行：
   		Track track = JSONParser.parse(TestConvertTrackToJson.TestJSONFiles[0]);
		TrackSummary trackSummary = TrackHelper.sumTrack(track);   
   执行完后TrackSummary中就是一次运动统计的结果，包括累计上升，累计下降，平均速度等，可以直接打印出来看：
        System.out.println(trackSummary);
   速度单位是单位/小时，其他单位都是米。