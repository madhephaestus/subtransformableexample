import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import eu.mihosoft.vrl.v3d.Transform
import eu.mihosoft.vrl.v3d.Vector3d
double d=15
double rot =5

Vector3d point = Vector3d.xyz(20,20, 0);

CSG cube  = new Cube(	point.x*2,// X dimention
			point.y*2,// Y dimention
			5//  Z dimention
			).toCSG()

println "Point starts at: "+point

Transform frame2 = new Transform().rotz(-rot).movey(d)

CSG cube2=cube.transformed(frame2)

Vector3d point2 = point.transformed(frame2)
println "Point2 starts at: "+point2+" from "+point
double offseCalculated = -0.75*point2.getY()
println "Offset calculated "+offseCalculated

Transform frame3 = frame2.movey(offseCalculated)

CSG cube3=cube.transformed(frame3)
Vector3d point3 = point.transformed(frame3)
println "Final location of the point "+point3


return cube3
	
	
	
