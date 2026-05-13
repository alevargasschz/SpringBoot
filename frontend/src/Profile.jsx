export default function Profile() {
    const name = 'Alejandro';
    const img = 'https://picsum.photos/id/101/200/300';
    const age = 19;
    return (
        <div>
            <h1>{name}'s Profile</h1>
            <img src={img} alt={`${name}'s profile picture`} />
            <p>Age: {age}</p>
        </div>
    );
}