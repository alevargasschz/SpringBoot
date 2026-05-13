export default function Landing() {
    const imgs = ['https://picsum.photos/id/237/200/300', 'https://picsum.photos/id/238/200/300', 'https://picsum.photos/id/239/200/300'];
    return (
        <>
            <h1>Welcome to the Landing Page</h1>
            <p>This is the main entry point of the application.</p>
            <img
                src="https://picsum.photos/id/237/200/300"
                alt="Description of the image"
            />
            {
                imgs.map((src, index) => (
                    <img
                        key={index}
                        src={src}
                        alt={`Image ${index + 1}`}
                    />
                ))
            }
        </>
    );
}
